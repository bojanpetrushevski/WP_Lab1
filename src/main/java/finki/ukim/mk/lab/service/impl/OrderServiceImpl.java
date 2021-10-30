package finki.ukim.mk.lab.service.impl;

import finki.ukim.mk.lab.model.Order;
import finki.ukim.mk.lab.repository.OrderRepository;
import finki.ukim.mk.lab.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order placeOrder(String balloonColor, String balloonSize, String clientName, String address) {
        Order order = new Order(balloonColor, balloonSize, clientName, address);

        orderRepository.addOrder(order);

        return order;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }
}
