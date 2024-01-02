package com.pawel.order.persistance;

import com.pawel.order.persistance.enums.PaymentStatus;
import com.pawel.order.persistance.enums.ShipmentStatus;

public record OrderDetails(PaymentStatus paymentStatus, ShipmentStatus shipmentStatus) {
}
