package fahrradhersteller.Model.Repositories;

import fahrradhersteller.Model.Entities.Schaltung;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchaltungRepository extends CrudRepository<Schaltung, Long> {
}
