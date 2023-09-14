package com.food.system.demo.order;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/orders", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/{id}")
    public ResponseEntity<?> create(@RequestBody Order order, @PathVariable("id") long userId) {
        Order savedOrder = orderService.createOrder(order, userId);

        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }
}
