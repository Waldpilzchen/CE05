package at.jku.ce05.fahrradhersteller.Model.Repositories;

import at.jku.ce05.fahrradhersteller.Model.Entities.Enums.SchaltungEnum;
import at.jku.ce05.fahrradhersteller.Model.Entities.Schaltung;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchaltungRepository extends CrudRepository<Schaltung, Long> {
    Schaltung findSchaltungBySchaltungEnum(SchaltungEnum schaltungEnum);
}
