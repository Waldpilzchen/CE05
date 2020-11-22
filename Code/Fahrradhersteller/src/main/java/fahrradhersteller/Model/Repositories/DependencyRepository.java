package fahrradhersteller.Model.Repositories;

import fahrradhersteller.Model.Entities.Dependency;
import fahrradhersteller.Model.Entities.Lenkertyp;
import fahrradhersteller.Model.Entities.Material;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DependencyRepository extends CrudRepository<Dependency, Long> {

    List<Dependency> findAllByLenkertyp(Lenkertyp l);

    List<Dependency> findAllByMaterial(Material m);
}
