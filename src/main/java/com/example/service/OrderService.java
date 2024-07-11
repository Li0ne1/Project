package com.example.service;

import com.example.entity.Order;

public interface OrderService {
    boolean placeOrder(Long productId, int quantity, String customerName, String shippingAddress, int creditCardNumber);

    Long saveOrder(Order order);

    Order getOrderById(Long id);
}
