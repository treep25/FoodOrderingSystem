package com.food.system.demo.order;

import com.food.system.demo.customer.Customer;
import com.food.system.demo.customer.CustomerRepository;
import com.food.system.demo.dessert.Dessert;
import com.food.system.demo.dessert.DessertRepository;
import com.food.system.demo.lunch.Lunch;
import com.food.system.demo.lunch.LunchRepository;
import com.food.system.demo.dish.Dish;
import com.food.system.demo.dish.DishRepository;
import com.food.system.demo.drink.Drink;
import com.food.system.demo.drink.DrinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderService {

    private final OrderRepository orderRepository;
    private final LunchRepository lunchRepository;
    private final DishRepository dishRepository;
    private final DessertRepository dessertRepository;
    private final DrinkRepository drinkRepository;
    private final CustomerRepository customerRepository;


    public Order createOrder(Order order, long userId) {
        Customer customer = customerRepository.findById(userId).orElseThrow(RuntimeException::new);

        order.setUserID(customer.getId());

        Dessert savedDessert = dessertRepository.save(order.getLunch().getDessert());
        Drink savedDrink = null;
        if (order.getLunch().getDish().getDrink() != null) {
            savedDrink = drinkRepository.save(order.getLunch().getDish().getDrink());
        }

        Dish savedDish = dishRepository.save(order.getLunch().getDish());


        Lunch savedLunch = lunchRepository.save(order.getLunch());

        savedLunch.setPrice(savedDish.getPrice() + savedDessert.getPrice());
        if (savedDrink != null) {
            savedLunch.setPrice(savedLunch.getPrice() + savedDrink.getPrice());
        }
        order.setTotal(savedLunch.getPrice());

        customer.getOrders().add(order);
        Order savedOrder = orderRepository.save(order);
        customerRepository.save(customer);

        return savedOrder;
    }
}
