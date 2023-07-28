package com.geekster.Food_delivery.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FoodOrder {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodOrderId;

    @ManyToOne
    @JoinColumn(name = "food_item_id")
    private FoodMenu foodItem;

    @OneToOne
    private User user;
}
