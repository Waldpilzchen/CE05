package at.jku.ce05.fahrradhersteller.Model.Repositories;

import at.jku.ce05.fahrradhersteller.Model.Entities.Enums.LenkertypEnum;
import at.jku.ce05.fahrradhersteller.Model.Entities.Lenkertyp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LenkertypRepository extends CrudRepository<Lenkertyp, Long> {

    long findById (long id);
    Lenkertyp findLenkertypByLenkertypEnum(LenkertypEnum lenkertypEnum);
}
