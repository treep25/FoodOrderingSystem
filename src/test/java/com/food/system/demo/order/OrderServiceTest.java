package com.food.system.demo.order;

import com.food.system.demo.customer.Customer;
import com.food.system.demo.customer.CustomerRepository;
import com.food.system.demo.dessert.Dessert;
import com.food.system.demo.dessert.DessertRepository;
import com.food.system.demo.dish.Dish;
import com.food.system.demo.dish.DishRepository;
import com.food.system.demo.dish.cuisine.Cuisine;
import com.food.system.demo.drink.Drink;
import com.food.system.demo.drink.DrinkRepository;
import com.food.system.demo.lunch.Lunch;
import com.food.system.demo.lunch.LunchRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private LunchRepository lunchRepository;

    @Mock
    private DishRepository dishRepository;

    @Mock
    private DessertRepository dessertRepository;

    @Mock
    private DrinkRepository drinkRepository;

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private OrderService orderService;

    @Test
    public void testCreateOrder() {
        //given
        Customer customer = Mockito.mock(Customer.class);
        when(customer.getId()).thenReturn(1L);
        when(customer.getOrders()).thenReturn(new ArrayList<>());

        Dessert dessert = new Dessert(1L, "Ice Cream", 5L);
        Drink drink = new Drink(1L, "Cola", 2L, false, true);
        Dish dish = new Dish(1L, "Spaghetti", 10L, drink, Cuisine.ITALIAN);
        Lunch lunch = new Lunch(1L, dish, dessert, 17L);


        when(customerRepository.findById(1L)).thenReturn(java.util.Optional.of(customer));
        when(dessertRepository.save(any(Dessert.class))).thenReturn(dessert);
        when(drinkRepository.save(any(Drink.class))).thenReturn(drink);
        when(dishRepository.save(any(Dish.class))).thenReturn(dish);
        when(lunchRepository.save(any(Lunch.class))).thenReturn(lunch);

        Order order = new Order();
        order.setLunch(lunch);

        when(orderRepository.save(any(Order.class))).thenReturn(order);

        //when
        Order savedOrder = orderService.createOrder(order, 1L);

        //then
        assertNotNull(savedOrder);
        assertEquals(17L, savedOrder.getTotal());
        assertEquals(1, customer.getOrders().size());
    }
}