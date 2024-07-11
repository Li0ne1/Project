package com.example.service.impl;

import com.example.entity.Inventory;
import com.example.entity.Order;
import com.example.repository.InventoryRepository;
import com.example.repository.OrderRepository;
import com.example.service.OrderService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepo;
    private final InventoryRepository inventoryRepo;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepo, InventoryRepository inventoryRepo) {
        this.orderRepo = orderRepo;
        this.inventoryRepo = inventoryRepo;
    }


    @Transactional
    @Override
    public boolean placeOrder(Long productId, int quantity, String customerName, String shippingAddress, int creditCardNumber) {
        Optional<Inventory> inventoryOpt = inventoryRepo.findById(productId);
        if (inventoryOpt.isPresent()) {
            Inventory inventory = inventoryOpt.get();
            if (inventory.getQuantity() >= quantity) {

                inventory.setQuantity(inventory.getQuantity() - quantity);
                inventoryRepo.save(inventory);

       
                Order order = new Order();
                order.setProductId(productId);
                order.setQuantity(quantity);
                order.setTotalPrice(String.valueOf(Double.parseDouble(inventory.getPrice()) * quantity));
                order.setCustomerName(customerName);
                order.setShippingAddress(shippingAddress);
                order.setCreditCardNumber(creditCardNumber);


                orderRepo.save(order);
                return true;
            } else {
                throw new RuntimeException("Insufficient stock");
            }
        } else {
            throw new RuntimeException("Product not found");
        }
    }

    @Override
    public Long saveOrder(Order order) {
        Integer quantity = order.getQuantity();
        String totalPrice = order.getTotalPrice();
        String customerName = order.getCustomerName();
        int phoneNumber = order.getPhoneNumber();
        String shippingAddress = order.getShippingAddress();
        int creditCardNumber = order.getCreditCardNumber();
        if(quantity <= 0){
            throw new RuntimeException("Quantity is incorrect");
        }
        if(StringUtils.isEmpty(totalPrice)){
            throw new RuntimeException("Total Price can not be null");
        }
        if(StringUtils.isEmpty(customerName)){
            throw new RuntimeException("Customer name can not be null");
        }
        if(phoneNumber == 0){
            throw new RuntimeException("Phone number can not be empty");
        }
        if(StringUtils.isEmpty(shippingAddress)){
            throw new RuntimeException("Shipping Address can not be null");
        }
        if(creditCardNumber == 0){
            throw new RuntimeException("Credit Card Number cannot be empty");
        }
        Order saveOrder = orderRepo.save(order);
        return saveOrder.getId();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepo.findById(id).get();
    }


}
