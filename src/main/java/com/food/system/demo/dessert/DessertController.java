package com.food.system.demo.dessert;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/desserts", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DessertController {

    private final DessertService dessertService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(dessertService.getAllDesserts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        return ResponseEntity.ok(dessertService.getDessertById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Dessert dessert) {
        Dessert savedDessert = dessertService.createDessert(dessert);

        return new ResponseEntity<>(savedDessert, HttpStatus.CREATED);
    }
}
