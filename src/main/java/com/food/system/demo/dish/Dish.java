package com.food.system.demo.dish;

import com.food.system.demo.dish.cuisine.Cuisine;
import com.food.system.demo.drink.Drink;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private long price;
    @ManyToOne(cascade = CascadeType.ALL)
    private Drink drink;
    @Enumerated(value = EnumType.STRING)
    private Cuisine cuisine;
}
