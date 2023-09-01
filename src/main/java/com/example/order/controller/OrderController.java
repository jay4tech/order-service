package com.example.order.controller;

import com.example.order.model.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "order")
public class OrderController {
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable String id) {
        return new Order(id, "Product_" + id, 10);
    }
}