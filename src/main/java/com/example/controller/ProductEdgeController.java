package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductEdgeController {
    @GetMapping("/product_edge")
    public String showProductEdge() {
        return "product_edge";
    }
}