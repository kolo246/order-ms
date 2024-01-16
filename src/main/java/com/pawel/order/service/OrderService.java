package com.pawel.order.service;

import com.pawel.order.api.dto.OrderDto;
import com.pawel.order.api.dto.OrderPostDto;
import com.pawel.order.persistance.OrderDetails;
import com.pawel.order.persistance.OrderRepository;
import com.pawel.order.persistance.enums.PaymentStatus;
import com.pawel.order.persistance.enums.ShipmentStatus;
import com.pawel.order.persistance.model.Order;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.jboss.logging.Logger;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@ApplicationScoped
public class OrderService {

    private static final Logger logger = Logger.getLogger(OrderService.class);

    @Inject
    OrderRepository orderRepository;

    @Transactional
    public OrderDto getOrder(UUID orderId) {
        Order order = orderRepository.findByIdOptional(orderId)
                .orElseThrow(() -> new NotFoundException("Order with ID: %s not exist".formatted(orderId.toString())));
        OrderDetails orderDetails = new OrderDetails(PaymentStatus.PROCESSING, ShipmentStatus.PENDING);
        return new OrderDto(order.getOrderId(), order.getOrderDate(), orderDetails);
    }

    @Transactional
    public OrderDto makeOrder(OrderPostDto orderPostDto) {
        UUID orderId = UUID.randomUUID();
        Date date =  Date.from(Instant.now());
        Order order = new Order(orderId, orderPostDto.customerId(), BigDecimal.ONE, date);
        orderRepository.save(order);
        OrderDetails orderDetails = new OrderDetails(PaymentStatus.PROCESSING, ShipmentStatus.PENDING);
        return new OrderDto(orderId, date, orderDetails);
    }
}
