package fahrradhersteller.Model.Repositories;

import fahrradhersteller.Model.Entities.Enums.LenkertypEnum;
import fahrradhersteller.Model.Entities.Lenkertyp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LenkertypRepository extends CrudRepository<Lenkertyp, Long> {

    long findById (long id);
    Lenkertyp findLenkertypByLenkertypEnum(LenkertypEnum lenkertypEnum);
}
