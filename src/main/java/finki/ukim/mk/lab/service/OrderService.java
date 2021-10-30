package finki.ukim.mk.lab.service;

import finki.ukim.mk.lab.model.Order;

import java.util.List;

public interface OrderService {
    Order placeOrder(String balloonColor, String balloonSize, String clientName, String address);
    List<Order> getAllOrders();
}
