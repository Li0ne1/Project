package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductFoilController {
    @GetMapping("/product_foil")
    public String showProductFoil() {
        return "product_foil";
    }
}