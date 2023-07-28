package com.geekster.Food_delivery.services;

import com.geekster.Food_delivery.models.FoodMenu;
import com.geekster.Food_delivery.repos.IFoodMenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodMenuService {
    @Autowired
    private IFoodMenuRepo foodItemRepository;


    public List<FoodMenu> getAllFoodItems() {
        return foodItemRepository.findAll();
    }

    public FoodMenu createFoodItem(FoodMenu foodItem) {
        return foodItemRepository.save(foodItem);
    }

    public FoodMenu getFoodItemById(Long id) {
        return foodItemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Food item not found"));
    }

    public void deleteFoodItem(Long id) {
        foodItemRepository.deleteById(id);
    }

    public boolean addFoodItem(FoodMenu foodItem) {
        foodItemRepository.save(foodItem);
        return true;
    }
}
