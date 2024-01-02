package com.pawel.order.api.dto;

import com.pawel.order.persistance.OrderDetails;

import java.sql.Timestamp;
import java.util.UUID;

public record OrderDto(UUID orderId, Timestamp timestamp, OrderDetails orderDetails) {
}
