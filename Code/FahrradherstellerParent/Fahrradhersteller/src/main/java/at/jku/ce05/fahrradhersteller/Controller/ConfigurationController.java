package at.jku.ce05.fahrradhersteller.Controller;

import at.jku.ce05.fahrradhersteller.Client.FIBUClient;
import at.jku.ce05.fahrradhersteller.Client.LieferantClient;
import at.jku.ce05.fahrradhersteller.Model.Entities.*;
import at.jku.ce05.fahrradhersteller.Model.Entities.Enums.GriffEnum;
import at.jku.ce05.fahrradhersteller.Model.Entities.Enums.LenkertypEnum;
import at.jku.ce05.fahrradhersteller.Model.Entities.Enums.MaterialEnum;
import at.jku.ce05.fahrradhersteller.Model.Entities.Enums.SchaltungEnum;
import at.jku.ce05.fahrradhersteller.Model.Repositories.*;
import at.jku.ce05.fahrradhersteller.Model.Service;
import at.jku.ce05.shared.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ConfigurationController {

    private LenkertypRepository lenkertypRepository;
    private MaterialRepository materialRepository;
    private SchaltungRepository schaltungRepository;
    private GriffRepository griffRepository;
    private DependencyRepository dependencyRepository;
    private OrderRepository orderRepository;

    @Autowired
    public ConfigurationController(LenkertypRepository lenkertypRepository, MaterialRepository materialRepository,
                                   SchaltungRepository schaltungRepository, GriffRepository griffRepository,
                                   DependencyRepository dependencyRepository, OrderRepository orderRepository) {
        this.lenkertypRepository = lenkertypRepository;
        this.materialRepository = materialRepository;
        this.schaltungRepository = schaltungRepository;
        this.griffRepository = griffRepository;
        this.dependencyRepository = dependencyRepository;
        this.orderRepository = orderRepository;
    }

    @GetMapping("/getAvailableHandlebarTypes")
    public List<String> getAvailableHandlebarTypes() {
        List<Lenkertyp> lenkertypen = new ArrayList<>();
        lenkertypRepository.findAll().forEach(lenkertypen::add);
        List<String> typeNames = new ArrayList<>();
        lenkertypen.forEach(t -> typeNames.add(t.getLenkertypEnum().name()));
        return typeNames;
    }

    @PostMapping("/getAvailableHandlebarMaterials/{lenkertyp}")
    public List<String> getAvailableHandlebarMaterials(@PathVariable("lenkertyp") String lenkertypChoice) {
        List<Material> materials = new ArrayList<>();
        materialRepository.findAll().forEach(materials::add);
        Lenkertyp l = lenkertypRepository.findLenkertypByLenkertypEnum(LenkertypEnum.valueOf(lenkertypChoice.toUpperCase()));
        List<Dependency> dependencies = dependencyRepository.findAllByLenkertyp(l);
        List<Material> invalidMaterials = new ArrayList<>();
        dependencies.forEach(d -> invalidMaterials.add(d.getMaterial()));
        materials.removeAll(invalidMaterials);
        List<String> materialNames = new ArrayList<>();
        materials.forEach(m -> materialNames.add(m.getMaterialEnum().name()));
        return materialNames;
    }

    @PostMapping("/getAvailableHandlebarGearshifts/{lenkertyp}/{material}")
    public List<String> getAvailableHandlebarGearshifts(@PathVariable("lenkertyp") String lenkertypChoice,
                                                        @PathVariable("material") String materialChoice) {
        List<Schaltung> schaltungen = new ArrayList<>();
        schaltungRepository.findAll().forEach(schaltungen::add);
        Lenkertyp l = lenkertypRepository.findLenkertypByLenkertypEnum(LenkertypEnum.valueOf(lenkertypChoice.toUpperCase()));
        List<Dependency> lenkertypDependencies = dependencyRepository.findAllByLenkertyp(l);
        Material m = materialRepository.findMaterialByMaterialEnum(MaterialEnum.valueOf(materialChoice.toUpperCase()));
        List<Dependency> materialDependencies = dependencyRepository.findAllByMaterial(m);
        List<Schaltung> invalidSchaltungen = new ArrayList<>();
        lenkertypDependencies.forEach(ld -> invalidSchaltungen.add(ld.getSchaltung()));
        materialDependencies.forEach(md -> invalidSchaltungen.add(md.getSchaltung()));
        schaltungen.removeAll(invalidSchaltungen);
        List<String> schaltungNames = new ArrayList<>();
        schaltungen.forEach(s -> schaltungNames.add(s.getSchaltungEnum().name()));
        return schaltungNames;
    }

    @PostMapping("/getAvailableHandleMaterials/{lenkertyp}/{material}/{schaltung}")
    public List<String> getAvailableHandleMaterials(@PathVariable("lenkertyp") String lenkertypChoice,
                                                    @PathVariable("material") String materialChoice,
                                                    @PathVariable("schaltung") String schaltungChoice) {
        List<Griff> griffe = new ArrayList<>();
        griffRepository.findAll().forEach(griffe::add);
        Lenkertyp l = lenkertypRepository.findLenkertypByLenkertypEnum(LenkertypEnum.valueOf(lenkertypChoice.toUpperCase()));
        List<Dependency> lenkertypDependencies = dependencyRepository.findAllByLenkertyp(l);
        Material m = materialRepository.findMaterialByMaterialEnum(MaterialEnum.valueOf(materialChoice.toUpperCase()));
        List<Dependency> materialDependencies = dependencyRepository.findAllByMaterial(m);
        Schaltung s = schaltungRepository.findSchaltungBySchaltungEnum(SchaltungEnum.valueOf(schaltungChoice.toUpperCase()));
        List<Dependency> schaltungDependencies = dependencyRepository.findAllBySchaltung(s);
        List<Griff> invalidGriffe = new ArrayList<>();
        lenkertypDependencies.forEach(ld -> invalidGriffe.add(ld.getGriff()));
        materialDependencies.forEach(md -> invalidGriffe.add(md.getGriff()));
        schaltungDependencies.forEach(sd -> invalidGriffe.add(sd.getGriff()));
        griffe.removeAll(invalidGriffe);
        List<String> griffNames = new ArrayList<>();
        griffe.forEach(g -> griffNames.add(g.getGriffEnum().name()));
        return griffNames;
    }

    @PostMapping("/getOrderConfirmation/{lenkertyp}/{material}/{schaltung}/{griff}")
    public ResponseEntity<Object> handleOrder(@PathVariable("lenkertyp") String lenkertypChoice,
                                              @PathVariable("material") String materialChoice,
                                              @PathVariable("schaltung") String schaltungChoice,
                                              @PathVariable("griff") String griffChoice) {
        Order order = new Order();
        Lenkertyp l = lenkertypRepository.findLenkertypByLenkertypEnum(LenkertypEnum.valueOf(lenkertypChoice.toUpperCase()));
        Material m = materialRepository.findMaterialByMaterialEnum(MaterialEnum.valueOf(materialChoice.toUpperCase()));
        Schaltung s = schaltungRepository.findSchaltungBySchaltungEnum(SchaltungEnum.valueOf(schaltungChoice.toUpperCase()));
        Griff g = griffRepository.findGriffByGriffEnum(GriffEnum.valueOf(griffChoice.toUpperCase()));
        order.setLenkertyp(l);
        order.setMaterial(m);
        order.setSchaltung(s);
        order.setGriff(g);
        OrderDTO orderClient;
        orderClient = Service.convertToOrderDTO(order);
        OrderDTO orderSupplier1 = new OrderDTO();
        OrderDTO orderSupplier2 = new OrderDTO();
        try {
            orderSupplier1 = LieferantClient.getOfferFromSupplierOne(orderClient);
            Thread.sleep(10);
            orderSupplier2 = LieferantClient.getOfferFromSupplierTwo(orderClient);
        }
        catch (ConnectException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Could not reach Suppliers");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An error occured");
        }
        OrderDTO chosenOrder = orderSupplier1.evaluateOffer(orderSupplier2);
        order.setDeliveryDate(chosenOrder.getDeliveryDate());
        order.setPrice(chosenOrder.getPrice());
        order = orderRepository.save(order);
        chosenOrder.setId(order.getId());

        System.out.println("I came here");

        try {
            FIBUClient fibuClient = new FIBUClient();
            fibuClient.startClient();
            fibuClient.addConfigurationOrder(chosenOrder);
        }
        catch (java.rmi.ConnectException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Could not connect a partner system, please try again later");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An error occured");
        }

        return ResponseEntity.ok(chosenOrder);
    }
}