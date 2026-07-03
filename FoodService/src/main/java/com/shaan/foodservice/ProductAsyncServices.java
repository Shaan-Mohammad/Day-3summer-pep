package com.shaan.foodservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductAsyncServices {

    @Autowired
    private RestTemplate restTemplate;

    // Synchronous Task
    public String placeOrder() {

        System.out.println("Checking food availability...");

        String response = restTemplate.getForObject(
                "http://localhost:8081/food/check",
                String.class);

        return response;
    }

    // Background Task 1
    @Async
    public void notifyRestaurant() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Restaurant has been notified.");
    }

    // Background Task 2
    @Async
    public void assignDeliveryPartner() {

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Delivery Partner Assigned.");
    }

    // Background Task 3
    @Async
    public void sendConfirmationSMS() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Confirmation SMS Sent.");
    }
}