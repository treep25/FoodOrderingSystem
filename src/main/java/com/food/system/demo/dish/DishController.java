package com.food.system.demo.dish;

import com.food.system.demo.dish.cuisine.Cuisine;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/dishes", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DishController {

    private final DishService dishService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(dishService.getAllDishes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        return ResponseEntity.ok(dishService.getDishById(id));
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllByCuisine(@RequestParam String cuisine) {
        return ResponseEntity
                .ok(dishService.getAllDishesByCuisine(Cuisine.valueOf(cuisine)));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Dish dish) {
        Dish savedDish = dishService.createDish(dish);

        return new ResponseEntity<>(savedDish, HttpStatus.CREATED);
    }
}
