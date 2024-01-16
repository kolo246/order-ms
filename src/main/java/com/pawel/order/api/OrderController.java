package com.pawel.order.api;

import com.pawel.order.api.dto.OrderDto;
import com.pawel.order.api.dto.OrderPostDto;
import com.pawel.order.service.OrderService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path(value = "orders")
public class OrderController {

    @Inject
    OrderService orderService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createOrder(OrderPostDto orderPostDto ){
        OrderDto orderDto = orderService.makeOrder(orderPostDto);
        return Response.ok(orderDto).build();
    }

    @GET
    @Path(value = "/{order-id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrder(@PathParam("order-id") UUID orderId) {
        OrderDto orderDto = orderService.getOrder(orderId);
        return Response.ok(null).build();
    }
}
