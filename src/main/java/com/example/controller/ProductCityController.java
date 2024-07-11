package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductCityController {
    @GetMapping("/product_city")
    public String showProductCity() {
        return "product_city";
    }
}