package fahrradhersteller.Model.init;

import fahrradhersteller.Model.Entities.Enums.GriffEnum;
import fahrradhersteller.Model.Entities.Enums.LenkertypEnum;
import fahrradhersteller.Model.Entities.Enums.MaterialEnum;
import fahrradhersteller.Model.Entities.Enums.SchaltungEnum;
import fahrradhersteller.Model.Entities.Griff;
import fahrradhersteller.Model.Entities.Lenkertyp;
import fahrradhersteller.Model.Entities.Material;
import fahrradhersteller.Model.Entities.Schaltung;
import fahrradhersteller.Model.Repositories.GriffRepository;
import fahrradhersteller.Model.Repositories.LenkertypRepository;
import fahrradhersteller.Model.Repositories.MaterialRepository;
import fahrradhersteller.Model.Repositories.SchaltungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements ApplicationRunner {

    private LenkertypRepository lenkertypRepository;
    private MaterialRepository materialRepository;
    private SchaltungRepository schaltungRepository;
    private GriffRepository griffRepository;

    @Autowired
    public DataInit(LenkertypRepository lenkertypRepository, MaterialRepository materialRepository,
                    SchaltungRepository schaltungRepository, GriffRepository griffRepository) {
        this.lenkertypRepository = lenkertypRepository;
        this.materialRepository = materialRepository;
        this.schaltungRepository = schaltungRepository;
        this.griffRepository = griffRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        long lenkertypCount = lenkertypRepository.count();
        long materialCount = materialRepository.count();
        long schaltungCount = schaltungRepository.count();
        long griffCount = griffRepository.count();

        if (lenkertypCount == 0) {
            Lenkertyp typ1 = new Lenkertyp(LenkertypEnum.FLATBARLENKER);
            Lenkertyp typ2 = new Lenkertyp(LenkertypEnum.RENNRADLENKER);
            Lenkertyp typ3 = new Lenkertyp(LenkertypEnum.BULLHORNLENKER);

            lenkertypRepository.save(typ1);
            lenkertypRepository.save(typ2);
            lenkertypRepository.save(typ3);
        }
        if (materialCount == 0) {
            Material material1 = new Material(MaterialEnum.ALUMINIUM);
            Material material2 = new Material(MaterialEnum.STAHL);
            Material material3 = new Material(MaterialEnum.KUNSTSTOFF);

            materialRepository.save(material1);
            materialRepository.save(material2);
            materialRepository.save(material3);
        }
        if (schaltungCount == 0) {
            Schaltung schaltung1 = new Schaltung(SchaltungEnum.KETTENSCHALTUNG);
            Schaltung schaltung2 = new Schaltung(SchaltungEnum.NABENSCHALTUNG);
            Schaltung schaltung3 = new Schaltung(SchaltungEnum.TRETLAGERSCHALTUNG);

            schaltungRepository.save(schaltung1);
            schaltungRepository.save(schaltung2);
            schaltungRepository.save(schaltung3);
        }
        if (griffCount == 0) {
            Griff griff1 = new Griff(GriffEnum.LEDERGRIFF);
            Griff griff2 = new Griff(GriffEnum.SCHAUMSTOFFGRIFF);
            Griff griff3 = new Griff(GriffEnum.KUNSTSTOFFGRIFF);

            griffRepository.save(griff1);
            griffRepository.save(griff2);
            griffRepository.save(griff3);
        }
    }
}
