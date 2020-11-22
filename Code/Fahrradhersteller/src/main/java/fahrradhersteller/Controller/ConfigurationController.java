package fahrradhersteller.Controller;

import fahrradhersteller.Model.Entities.Dependency;
import fahrradhersteller.Model.Entities.Enums.LenkertypEnum;
import fahrradhersteller.Model.Entities.Enums.MaterialEnum;
import fahrradhersteller.Model.Entities.Lenkertyp;
import fahrradhersteller.Model.Entities.Material;
import fahrradhersteller.Model.Entities.Schaltung;
import fahrradhersteller.Model.Repositories.*;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ConfigurationController {

    private LenkertypRepository lenkertypRepository;
    private MaterialRepository materialRepository;
    private SchaltungRepository schaltungRepository;
    private GriffRepository griffRepository;
    private DependencyRepository dependencyRepository;

    @Autowired
    public ConfigurationController(LenkertypRepository lenkertypRepository, MaterialRepository materialRepository,
                                   SchaltungRepository schaltungRepository, GriffRepository griffRepository,
                                   DependencyRepository dependencyRepository) {
        this.lenkertypRepository = lenkertypRepository;
        this.materialRepository = materialRepository;
        this.schaltungRepository = schaltungRepository;
        this.griffRepository = griffRepository;
        this.dependencyRepository = dependencyRepository;
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
        List<String> schaltungenNames = new ArrayList<>();
        schaltungen.forEach(s -> schaltungenNames.add(s.getSchaltungEnum().name()));
        return schaltungenNames;
    }
}