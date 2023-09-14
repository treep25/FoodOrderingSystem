package com.food.system.demo.lunch;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LunchService {

    private final LunchRepository lunchRepository;

    public List<Lunch> getAllLunches() {
        return lunchRepository.findAll();
    }
}
