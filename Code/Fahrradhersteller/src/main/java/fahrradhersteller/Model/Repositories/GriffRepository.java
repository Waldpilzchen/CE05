package fahrradhersteller.Model.Repositories;

import fahrradhersteller.Model.Entities.Griff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GriffRepository extends CrudRepository<Griff, Long> {
}
