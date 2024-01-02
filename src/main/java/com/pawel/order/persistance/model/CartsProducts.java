package com.pawel.order.persistance.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "CARTS_PRODUCTS")
public class CartsProducts {

    @Id
    private UUID cartId;
    @Id
    private UUID productId;
}
