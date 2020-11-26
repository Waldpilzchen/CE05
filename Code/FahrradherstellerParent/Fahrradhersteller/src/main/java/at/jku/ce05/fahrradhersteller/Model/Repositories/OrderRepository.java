package at.jku.ce05.fahrradhersteller.Model.Repositories;

import at.jku.ce05.fahrradhersteller.Model.Entities.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
