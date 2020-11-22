package fahrradhersteller.Controller;

import fahrradhersteller.Model.Entities.Lenkertyp;
import fahrradhersteller.Model.Repositories.LenkertypRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ConfigurationController {

    private LenkertypRepository lenkertypRepository;

    @Autowired
    public ConfigurationController(LenkertypRepository lenkertypRepository) {
        this.lenkertypRepository = lenkertypRepository;
    }

    @GetMapping("/getAvailableHandlebarTypes")
    public ResponseEntity<List<Lenkertyp>> getAvailableHandlebarTypes() {
        List<Lenkertyp> lenkertypen = new ArrayList<>();
        lenkertypRepository.findAll().forEach(lenkertypen::add);
        return ResponseEntity.ok(lenkertypen);
    }

}
