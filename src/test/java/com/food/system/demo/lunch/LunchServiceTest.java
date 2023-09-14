package com.food.system.demo.lunch;

import com.food.system.demo.dessert.Dessert;
import com.food.system.demo.dish.Dish;
import com.food.system.demo.dish.cuisine.Cuisine;
import com.food.system.demo.drink.Drink;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LunchServiceTest {

    @Mock
    private LunchRepository lunchRepository;
    @InjectMocks
    private LunchService lunchService;

    @Test
    public void testGetAllLunches() {
        //given
        Drink drink1 = new Drink(1L, "Drink", 123, true, false);

        Dish dish1 = new Dish(1L, "Dish1", 10L, drink1, Cuisine.ITALIAN);
        Dish dish2 = new Dish(2L, "Dish2", 8L, null, Cuisine.MEXICAN);

        Dessert dessert1 = new Dessert(1L, "Dessert1", 5L);
        Dessert dessert2 = new Dessert(2L, "Dessert2", 7L);

        Lunch lunch1 = new Lunch(1L, dish1, dessert1, 15L);
        Lunch lunch2 = new Lunch(2L, dish2, dessert2, 15L);

        List<Lunch> lunchList = Arrays.asList(lunch1, lunch2);

        when(lunchRepository.findAll()).thenReturn(lunchList);

        //when
        List<Lunch> result = lunchService.getAllLunches();

        //then
        assertEquals(2, result.size());
        assertEquals("Dish1", result.get(0).getDish().getName());
        assertEquals("Drink", result.get(0).getDish().getDrink().getName());
        assertEquals("Dish2", result.get(1).getDish().getName());
        assertEquals("Dessert1", result.get(0).getDessert().getName());
        assertEquals("Dessert2", result.get(1).getDessert().getName());
    }
}