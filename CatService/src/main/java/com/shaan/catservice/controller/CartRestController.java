package com.shaan.catservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartRestController {
    @GetMapping("/cart/getData")
   public String getCartData(){
        return  "Returning Data from CART-SERVICE";
    }




}
