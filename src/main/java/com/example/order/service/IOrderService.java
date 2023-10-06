package com.example.order.service;

import com.example.order.entity.Order;

import java.util.List;

public interface IOrderService {
    Order getOrder(Long id);

    void deleteOrder(Long id);

    Order updateOrder(Order order);

    Order createOrder(Order order);

    public List<Order> getOrderByUserId(Long userId);
}
