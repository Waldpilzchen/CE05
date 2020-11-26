package at.jku.ce05.fahrradhersteller.Model.Repositories;

import at.jku.ce05.fahrradhersteller.Model.Entities.Enums.MaterialEnum;
import at.jku.ce05.fahrradhersteller.Model.Entities.Material;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends CrudRepository<Material, Long> {

    Material findMaterialByMaterialEnum(MaterialEnum materialEnum);
}
