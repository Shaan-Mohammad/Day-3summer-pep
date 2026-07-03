package com.shaan.productservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/product")
    public String getProduct() throws InterruptedException {

        Thread.sleep(9000);

        return "Laptop Price = Rupees 65000";
    }
}