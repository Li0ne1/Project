package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductLandController {
    @GetMapping("/product_land")
    public String showProductLand() {
        return "product_land";
    }
}