package at.jku.ce05.fahrradhersteller.Model.Repositories;

import at.jku.ce05.fahrradhersteller.Model.Entities.Enums.GriffEnum;
import at.jku.ce05.fahrradhersteller.Model.Entities.Griff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GriffRepository extends CrudRepository<Griff, Long> {

    Griff findGriffByGriffEnum(GriffEnum griffEnum);
}
