package com.food.system.demo.dish;

import com.food.system.demo.dish.cuisine.Cuisine;
import com.food.system.demo.drink.DrinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DishService {

    private final DishRepository dishRepository;
    private final DrinkRepository drinkRepository;

    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    public List<Dish> getAllDishesByCuisine(Cuisine cuisine) {
        return dishRepository.getDishByCuisine(cuisine);
    }

    public Dish getDishById(long id) {
        return dishRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Dish createDish(Dish dish) {
        if (dish.getDrink() != null) {
            drinkRepository.save(dish.getDrink());
        }

        return dishRepository.save(dish);
    }

}
