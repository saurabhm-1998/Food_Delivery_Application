package com.geekster.Food_delivery.controllers;

import com.geekster.Food_delivery.models.FoodMenu;
import com.geekster.Food_delivery.models.FoodOrder;
import com.geekster.Food_delivery.services.FoodMenuService;
import com.geekster.Food_delivery.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private FoodMenuService foodMenuService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/fooditem")
    public List<FoodMenu> getAllFoodItems() {
        return foodMenuService.getAllFoodItems();
    }

    @GetMapping("/fooditem/{id}")
    public FoodMenu getFoodItemById(@PathVariable Long id) {
        return foodMenuService.getFoodItemById(id);
    }

    @PostMapping("/fooditem")
    public ResponseEntity<String> createFoodItem(@RequestBody FoodMenu foodItem) {
        HttpStatus status;
        String msg = "";
        if(foodMenuService.addFoodItem(foodItem)){
            msg ="Food item added";
            status = HttpStatus.ACCEPTED;
        }else{
            msg ="Invalid information";
            status = HttpStatus.FORBIDDEN;
        }

        return new ResponseEntity<String>(msg,status);
    }

    @DeleteMapping("/fooditem/{id}")
    public void deleteFoodItem(@PathVariable Long id) {
        foodMenuService.deleteFoodItem(id);
    }

    @GetMapping("/orders")
    public List<FoodOrder> getAllOrders(){
        return orderService.getAllOrders();
    }
}
