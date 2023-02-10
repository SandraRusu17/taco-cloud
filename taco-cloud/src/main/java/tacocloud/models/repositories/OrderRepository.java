package tacocloud.models.repositories;

import tacocloud.models.data.Order;

public interface OrderRepository {

    Order save(Order order);
}
