package fahrradhersteller.Model.Repositories;

import fahrradhersteller.Model.Entities.Lenkertyp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LenkertypRepository extends CrudRepository<Lenkertyp, Long> {

    long findById (long id);
}
