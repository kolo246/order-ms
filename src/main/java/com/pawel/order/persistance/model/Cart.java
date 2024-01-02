package com.pawel.order.persistance.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "CART")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID cartId;

    @Column(name = "PURCHASER_ID")
    private UUID purchaserId;

    @Column(name = "CART_VALUE")
    private BigDecimal cartValue;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "CARTS_PRODUCTS",
            joinColumns = {@JoinColumn(name = "CART_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PRODUCT_ID")}
    )
    private Set<Product> products = new HashSet<>();

}
