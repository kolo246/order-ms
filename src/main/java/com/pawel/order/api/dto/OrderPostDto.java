package com.pawel.order.api.dto;

import java.util.UUID;

public record OrderPostDto(UUID customerId, UUID cartId) {
}
