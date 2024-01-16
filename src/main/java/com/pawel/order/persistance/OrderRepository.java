package com.pawel.order.persistance;

import com.pawel.order.persistance.model.Order;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.UUID;

@ApplicationScoped
public class OrderRepository implements PanacheRepositoryBase<Order, UUID> {

    @Inject
    EntityManager entityManager;

    public void save(Order order) {
        entityManager.merge(order);
    }
}
