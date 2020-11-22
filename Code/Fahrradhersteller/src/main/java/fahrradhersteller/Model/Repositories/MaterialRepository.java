package fahrradhersteller.Model.Repositories;

import fahrradhersteller.Model.Entities.Material;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends CrudRepository<Material, Long> {

}
