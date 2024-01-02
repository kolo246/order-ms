package com.pawel.order.service;

import com.pawel.order.api.dto.OrderDto;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class OrderService {

    public OrderDto getOrder(UUID orderId) {
        return null;
    }
}
