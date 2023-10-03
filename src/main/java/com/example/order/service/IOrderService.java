package com.example.order.service;

import com.example.order.entity.Order;

public interface IOrderService {
    Order getOrder(Long id);

    void deleteOrder(Long id);

    Order updateOrder(Order order);

    Order createOrder(Order order);
}
