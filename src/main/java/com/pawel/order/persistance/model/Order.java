package com.pawel.order.persistance.model;


import com.pawel.order.persistance.model.Cart;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID orderId;

    @Column(name = "PURCHASER_ID")
    private UUID purchaserId;

    @Column(name = "ORDER_TIMESTAMP")
    private Timestamp orderTimestamp;

    @Column(name = "CART_ID")
    private Cart cartId;
}