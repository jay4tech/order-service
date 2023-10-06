package com.example.order.service;

import com.example.order.entity.Order;
import com.example.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService{

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public Order getOrder(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteOrder(Long id) {
         orderRepository.deleteById(id);
    }

    @Override
    public Order updateOrder(Order order) {
        Optional<Order> optionalOrder = orderRepository.findById(order.getId());
        if(optionalOrder.isPresent()){
            order.setId(optionalOrder.get().getId());
            orderRepository.save(order);
        }
        return order;
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getOrderByUserId(Long userId) {
        return orderRepository.getOrderByUserId(userId);
    }
}
