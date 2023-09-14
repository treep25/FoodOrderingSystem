package com.food.system.demo.drink;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/drinks", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DrinkController {

    private final DrinkService drinkService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(drinkService.getAllDrinks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        return ResponseEntity.ok(drinkService.getDrinkById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Drink drink) {
        Drink savedDrink = drinkService.createDrink(drink);

        return new ResponseEntity<>(savedDrink, HttpStatus.CREATED);
    }
}
