package com.food.system.demo.drink;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DrinkService {

    private final DrinkRepository drinkRepository;

    public List<Drink> getAllDrinks() {
        return drinkRepository.findAll();
    }

    public Drink getDrinkById(long id) {
        return drinkRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Drink createDrink(Drink drink) {
        return drinkRepository.save(drink);
    }

}
