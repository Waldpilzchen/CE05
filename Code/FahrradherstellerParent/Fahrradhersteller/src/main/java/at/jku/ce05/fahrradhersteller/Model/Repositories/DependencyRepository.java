package at.jku.ce05.fahrradhersteller.Model.Repositories;

import at.jku.ce05.fahrradhersteller.Model.Entities.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DependencyRepository extends CrudRepository<Dependency, Long> {

    List<Dependency> findAllByLenkertyp(Lenkertyp l);

    List<Dependency> findAllByMaterial(Material m);

    List<Dependency> findAllBySchaltung(Schaltung s);

    List<Dependency> findAllByGriff(Griff g);
}
