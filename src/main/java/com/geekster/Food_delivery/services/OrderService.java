package com.geekster.Food_delivery.services;

import com.geekster.Food_delivery.models.FoodMenu;
import com.geekster.Food_delivery.models.FoodOrder;
import com.geekster.Food_delivery.models.User;
import com.geekster.Food_delivery.repos.IFoodMenuRepo;
import com.geekster.Food_delivery.repos.IOrderRepo;
import com.geekster.Food_delivery.repos.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    IOrderRepo iFoodOrderRepository;

    @Autowired
    IUserRepo iUserRepository;

    @Autowired
    IFoodMenuRepo foodItemRepository;

    public FoodOrder createOrder(FoodOrder foodOrder) {

        User user = iUserRepository.findByUserId(foodOrder.getUser().getUserId());
        foodOrder.setUser(user);
        FoodMenu foodItem = foodItemRepository.findByFoodItemId(foodOrder.getFoodItem().getFoodItemId());
        foodOrder.setFoodItem(foodItem);

        return iFoodOrderRepository.save(foodOrder);
    }

    public FoodOrder getOrderById(Long orderId) {
        return iFoodOrderRepository.findByFoodOrderId(orderId);
    }

    public List<FoodOrder> getAllOrders() {
        return iFoodOrderRepository.findAll();
    }
}
