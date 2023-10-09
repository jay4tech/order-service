package com.example.order.controller;


import com.example.order.entity.Order;
import com.example.order.model.Product;
import com.example.order.service.IOrderService;
import com.example.order.service.ServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @Autowired
    ServiceProxy serviceProxy;

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }

    @PostMapping("/")
    public Order createOrder(@RequestBody Order order) {
        Product product = serviceProxy.getProduct(order.getProductId());
        if (product != null) {
            return orderService.createOrder(order);
        } else {
            throw new RuntimeException("No Product Found");
        }
    }

    @PutMapping("/{id}")
    public Order updateOrder(@RequestBody Order order) {
        return orderService.updateOrder(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

    @GetMapping("/user/{userId}")
    public List<Order> getOrderByUserId(@PathVariable Long userId) {
        return orderService.getOrderByUserId(userId);
    }
}