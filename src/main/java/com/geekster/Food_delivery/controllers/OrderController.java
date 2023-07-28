package com.geekster.Food_delivery.controllers;

import com.geekster.Food_delivery.models.FoodOrder;
import com.geekster.Food_delivery.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService foodOrderService;

    @PostMapping()
    public FoodOrder createOrder(@RequestParam String userEmail, @RequestParam String token, @RequestBody FoodOrder foodOrder){
        return foodOrderService.createOrder(foodOrder);
    }

    @GetMapping("/{orderId}")
    public FoodOrder getOrderById(@PathVariable Long orderId){
        return foodOrderService.getOrderById(orderId);
    }
}
