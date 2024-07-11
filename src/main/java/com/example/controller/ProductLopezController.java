package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductLopezController {
    @GetMapping("/product_lopez")
    public String showProductLopez() {
        return "product_lopez";
    }
}
