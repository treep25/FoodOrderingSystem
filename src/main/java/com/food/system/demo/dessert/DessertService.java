package com.food.system.demo.dessert;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DessertService {

    private final DessertRepository dessertRepository;

    public List<Dessert> getAllDesserts() {
        return dessertRepository.findAll();
    }

    public Dessert getDessertById(long id) {
        return dessertRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Dessert createDessert(Dessert dessert) {
        return dessertRepository.save(dessert);
    }
}
