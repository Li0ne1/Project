package com.example.controller;

import com.example.entity.ShoppingCart;
import com.example.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;



    @PostMapping("/product_bath")
    public String addToCart(@ModelAttribute ShoppingCart shoppingCart, Model model) {
        if (shoppingCart.getProductId() == null) {
            model.addAttribute("error", "Product ID is required");
            return "product_bath";
        }
        shoppingCartService.addToCart(shoppingCart);
        model.addAttribute("message", "Item added to cart successfully");
        return "redirect:/shoppingCart";
    }

    @GetMapping("/shoppingCart")
    public String showShoppingCart() {
        return "shoppingCart";
    }
}

