package com.food.system.demo.lunch;

import com.food.system.demo.dessert.Dessert;
import com.food.system.demo.dish.Dish;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Lunch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Dish dish;
    @ManyToOne
    private Dessert dessert;
    private long price;
}
