package com.order_service.controller;

import com.order_service.models.OrderRequest;
import com.order_service.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderRequest> getOrders()
    {
        return orderService.getOrders();
    }

    @GetMapping("/{id}")
    public OrderRequest getOrder(@PathVariable Long id)
    {
        return orderService.getOrder(id);
    }

    @PostMapping
    public String placeOrder(@RequestBody OrderRequest orderRequest)
    {
        return orderService.insertOrder(orderRequest);
    }
}
