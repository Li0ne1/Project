package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "phone_number", nullable = false)
    private int phoneNumber;

    @Column(name = "shipping_address", nullable = false)
    private String shippingAddress;

    @Column(name = "credit_card_number", nullable = false)
    private int creditCardNumber;
}
