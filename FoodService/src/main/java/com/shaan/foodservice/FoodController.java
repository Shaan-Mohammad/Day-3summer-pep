package com.shaan.foodservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {

    @GetMapping("/food/check")
    public String checkFood() throws InterruptedException {

        System.out.println("Checking food availability...");

        Thread.sleep(5000);

        return "Pizza is available";
    }
}