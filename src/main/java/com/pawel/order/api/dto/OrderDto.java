package com.pawel.order.api.dto;

import com.pawel.order.persistance.OrderDetails;

import java.util.UUID;

public record OrderDto(UUID orderId, java.util.Date timestamp, OrderDetails orderDetails) {
}
