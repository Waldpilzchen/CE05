package fahrradhersteller.Model.Repositories;

import fahrradhersteller.Model.Entities.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
