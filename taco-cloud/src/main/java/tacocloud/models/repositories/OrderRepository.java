package tacocloud.models.repositories;

import org.springframework.data.repository.CrudRepository;
import tacocloud.models.data.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
