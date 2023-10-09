package com.example.order.service;

import com.example.order.entity.Order;
import com.example.order.model.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceProxy {

    private RestTemplate restTemplate;

    ServiceProxy() {
        restTemplate = new RestTemplate();
    }

    /**
     * Proxy is calling API Gateway
     *
     * @param productId
     * @return
     */
    public Product getProduct(Long productId) {
        return restTemplate.getForObject("http://localhost:8888/products/" + productId, Product.class);
    }

    /**
     *
     *  Proxy is calling API Gateway
     *
     * @param order
     */
    public void updateInventory(Order order) {
        HttpEntity<Order> request = new HttpEntity<>(order);
        restTemplate.exchange("http://localhost:8888/inventory/" , HttpMethod.PUT , request, String.class);
    }
}