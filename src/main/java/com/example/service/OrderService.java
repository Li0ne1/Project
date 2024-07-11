package com.example.service;

public interface OrderService {
    boolean placeOrder(Long productId, int quantity, String customerName, String shippingAddress, int creditCardNumber);
}
