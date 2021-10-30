package finki.ukim.mk.lab.repository;

import finki.ukim.mk.lab.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {
    List<Order> orders = new ArrayList<>(List.of(
            new Order("Green Balloon", "Big","John","London Street 123")
            ));

    public void addOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException();
        }

        orders.add(order);
    }

    public List<Order> getAllOrders() {
        return orders;
    }
}
