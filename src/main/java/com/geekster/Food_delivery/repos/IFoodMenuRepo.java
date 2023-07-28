package com.geekster.Food_delivery.repos;

import com.geekster.Food_delivery.models.FoodMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFoodMenuRepo extends JpaRepository<FoodMenu,Long> {
    FoodMenu findByFoodItemId(Long foodItemId);
}
