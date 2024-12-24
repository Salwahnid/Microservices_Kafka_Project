package org.example.orderservice;


import org.example.orderservice.entities.Order;
import org.example.orderservice.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderGraphQL {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private Product productClient;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order placeOrder(Long productId, Integer quantity) {
        Product.ProductResponse product = productClient.getProductById(productId);

        if (product.stock < quantity) {
            throw new RuntimeException("Insufficient stock for product: " + product.name);
        }

        Order order = new Order();
        order.setProductId(productId);
        order.setQuantity(quantity);
        order.setTotalPrice(product.price * quantity);

        return orderRepository.save(order);
    }
}
