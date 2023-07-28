package com.geekster.Food_delivery.repos;

import com.geekster.Food_delivery.models.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepo extends JpaRepository<FoodOrder,Long> {
    FoodOrder findByFoodOrderId(Long orderId);
}
