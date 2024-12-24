package org.example.orderservice.resolver;

import graphql.kickstart.tools.GraphQLMutationResolver;
import org.example.orderservice.entities.Order;
import org.example.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMutationResolver implements GraphQLMutationResolver {
    @Autowired
    private OrderService orderService;

    public Order createOrder(Long productId, Integer quantity) {
        return orderService.createOrder(productId, quantity);
    }
}

