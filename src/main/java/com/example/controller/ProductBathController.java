package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductBathController {
    @GetMapping("/product_bath")
    public String showProductBaath() {
        return "product_bath";
    }
}
