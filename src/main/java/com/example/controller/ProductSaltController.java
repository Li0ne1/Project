package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductSaltController {
    @GetMapping("/product_salt")
    public String showProductSalt() {
        return "product_salt";
    }
}
