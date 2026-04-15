package com.example.demo.controller;

import com.example.demo.service.ProductService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String dashboard(Model model) {
        model.addAttribute("products", service.getAll());
        return "dashboard";
    }

    @GetMapping("/category")
    public String filter(@RequestParam String category, Model model) {
        model.addAttribute("products", service.getByCategory(category));
        return "dashboard";

    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "WORKING";
    }




}