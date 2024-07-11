package com.example.service.impl;

import com.example.entity.Inventory;
import com.example.entity.ShoppingCart;
import com.example.repository.ShoppingCartRepository;
import com.example.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Override
    public void addToCart(ShoppingCart shoppingCart) {
        shoppingCartRepository.save(shoppingCart);
    }
}

