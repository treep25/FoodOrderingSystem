package com.food.system.demo.dish;

import com.food.system.demo.dish.cuisine.Cuisine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {

    List<Dish> getDishByCuisine(Cuisine cuisine);
}
