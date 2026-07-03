package com.shaan.paymentservice.controller;

import com.shaan.paymentservice.Consumer.CartRestConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
@Autowired
   private  CartRestConsumer consumer;
    @GetMapping("/payment/data")
   public String getPaymentData(){
       return "From Payment-Service"+consumer.getCartData();
   }
}
