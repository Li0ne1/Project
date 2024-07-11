package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductMarldonController {
    @GetMapping("/product_marldon")
    public String showProductMarldon() {
        return "product_marldon";
    }
}
