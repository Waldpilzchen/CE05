package at.jku.ce05.fahrradhersteller.Model.init;

import at.jku.ce05.fahrradhersteller.Model.Entities.*;
import at.jku.ce05.fahrradhersteller.Model.Entities.Enums.GriffEnum;
import at.jku.ce05.fahrradhersteller.Model.Entities.Enums.LenkertypEnum;
import at.jku.ce05.fahrradhersteller.Model.Entities.Enums.MaterialEnum;
import at.jku.ce05.fahrradhersteller.Model.Entities.Enums.SchaltungEnum;
import at.jku.ce05.fahrradhersteller.Model.Repositories.*;
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
    private DependencyRepository dependencyRepository;

    @Autowired
    public DataInit(LenkertypRepository lenkertypRepository, MaterialRepository materialRepository,
                    SchaltungRepository schaltungRepository, GriffRepository griffRepository,
                    DependencyRepository dependencyRepository) {
        this.lenkertypRepository = lenkertypRepository;
        this.materialRepository = materialRepository;
        this.schaltungRepository = schaltungRepository;
        this.griffRepository = griffRepository;
        this.dependencyRepository = dependencyRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        long lenkertypCount = lenkertypRepository.count();
        long materialCount = materialRepository.count();
        long schaltungCount = schaltungRepository.count();
        long griffCount = griffRepository.count();
        long dependenciesCount = dependencyRepository.count();
        Lenkertyp flatbar = new Lenkertyp(LenkertypEnum.FLATBARLENKER);
        Lenkertyp rennrad = new Lenkertyp(LenkertypEnum.RENNRADLENKER);
        Lenkertyp bullhorn = new Lenkertyp(LenkertypEnum.BULLHORNLENKER);
        Material aluminium = new Material(MaterialEnum.ALUMINIUM);
        Material stahl = new Material(MaterialEnum.STAHL);
        Material kunststoff = new Material(MaterialEnum.KUNSTSTOFF);
        Schaltung ketten = new Schaltung(SchaltungEnum.KETTENSCHALTUNG);
        Schaltung naben = new Schaltung(SchaltungEnum.NABENSCHALTUNG);
        Schaltung tretlager = new Schaltung(SchaltungEnum.TRETLAGERSCHALTUNG);
        Griff leder = new Griff(GriffEnum.LEDERGRIFF);
        Griff schaumstoff = new Griff(GriffEnum.SCHAUMSTOFFGRIFF);
        Griff grKunststoff = new Griff(GriffEnum.KUNSTSTOFFGRIFF);

        if (lenkertypCount == 0) {
            lenkertypRepository.save(flatbar);
            lenkertypRepository.save(rennrad);
            lenkertypRepository.save(bullhorn);
        }
        if (materialCount == 0) {
            materialRepository.save(aluminium);
            materialRepository.save(stahl);
            materialRepository.save(kunststoff);
        }
        if (schaltungCount == 0) {
            schaltungRepository.save(ketten);
            schaltungRepository.save(naben);
            schaltungRepository.save(tretlager);
        }
        if (griffCount == 0) {
            griffRepository.save(leder);
            griffRepository.save(schaumstoff);
            griffRepository.save(grKunststoff);
        }
        if (dependenciesCount == 0) {
            Dependency dependency = new Dependency();
            dependency.setLenkertyp(flatbar);
            dependency.setMaterial(stahl);
            dependencyRepository.save(dependency);

            dependency = new Dependency();
            dependency.setLenkertyp(rennrad);
            dependency.setMaterial(stahl);
            dependencyRepository.save(dependency);

            dependency = new Dependency();
            dependency.setMaterial(stahl);
            dependency.setSchaltung(naben);
            dependencyRepository.save(dependency);

            dependency = new Dependency();
            dependency.setMaterial(stahl);
            dependency.setSchaltung(tretlager);
            dependencyRepository.save(dependency);

            dependency = new Dependency();
            dependency.setMaterial(aluminium);
            dependency.setGriff(grKunststoff);
            dependencyRepository.save(dependency);

            dependency = new Dependency();
            dependency.setMaterial(stahl);
            dependency.setGriff(grKunststoff);
            dependencyRepository.save(dependency);

            dependency = new Dependency();
            dependency.setLenkertyp(flatbar);
            dependency.setGriff(leder);
            dependencyRepository.save(dependency);

            dependency = new Dependency();
            dependency.setLenkertyp(bullhorn);
            dependency.setGriff(leder);
            dependencyRepository.save(dependency);
        }
    }
}
