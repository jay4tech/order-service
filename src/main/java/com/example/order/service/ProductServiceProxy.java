package com.example.order.service;

import com.example.order.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductServiceProxy {

    private RestTemplate restTemplate;

    ProductServiceProxy(){
        restTemplate = new RestTemplate();
    }

    public Product getProduct(Long productId) {
        return restTemplate.getForObject("http://localhost:8081/products/" + productId, Product.class);
    }
}