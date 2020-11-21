package Model.Repositories;

import Model.Entities.Enums.LenkertypEnum;
import Model.Entities.Lenkertyp;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LenkertypRepository extends CrudRepository<Lenkertyp, LenkertypEnum> {
    Optional<Lenkertyp> findById (LenkertypEnum id);
}
