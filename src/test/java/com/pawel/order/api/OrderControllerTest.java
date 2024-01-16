package com.pawel.order.api;

import com.pawel.order.api.dto.OrderDto;
import com.pawel.order.persistance.OrderDetails;
import com.pawel.order.persistance.enums.PaymentStatus;
import com.pawel.order.persistance.enums.ShipmentStatus;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.hamcrest.Matchers.is;

@QuarkusTest
class OrderControllerTest {

    private static UUID ORDER_ID = UUID.randomUUID();

    @Test
    void testGetOrders() {
        OrderDto dtoResponse = RestAssured.given()
                .pathParam("order-id", ORDER_ID)
                .when().get("/orders/{order-id}")
                .then()
                .statusCode(200)
                .extract()
                .body().as(OrderDto.class);

        Assertions.assertEquals(dtoResponse.orderId(), ORDER_ID);
        Assertions.assertEquals(dtoResponse.orderDetails(), new OrderDetails(PaymentStatus.PROCESSING, ShipmentStatus.PENDING));
    }
}