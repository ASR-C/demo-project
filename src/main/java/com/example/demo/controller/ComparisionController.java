package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
public class ComparisionController {

    private final ProductService service;

    public ComparisionController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/compare")
    public String compare(@RequestParam Long p1, @RequestParam Long p2, Model model) {

        Product prod1 = service.getById(p1);
        Product prod2 = service.getById(p2);

        model.addAttribute("p1", prod1);
        model.addAttribute("p2", prod2);

        return "compare";
    }
}