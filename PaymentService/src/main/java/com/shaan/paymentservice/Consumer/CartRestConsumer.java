package com.shaan.paymentservice.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class CartRestConsumer {
    @Autowired
  private   DiscoveryClient discoveryClient;
    public String getCartData(){
        //fins CART-SERVICE instance from eureka
       List<ServiceInstance> instances= discoveryClient.getInstances("CART-SERVICE");
       if(instances==null || instances.isEmpty()){
           return "CART-SERVICE not available right now";
       }
       // Pick first available instance
       ServiceInstance instance=instances.get(0);
       //crrate url to call cart-service
       String url= instance.getUri()+"/cart/getData";
//call cart service
        RestTemplate restTemplate= new RestTemplate();
        return restTemplate.getForObject(url,String.class);

    }
}
