package com.food.system.demo.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/customer/myself", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> create() {
        return new ResponseEntity<>(customerService.createMyself(
                Customer.builder().name("ADMIN").build()), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getMyself(@RequestParam long userId) {
        return ResponseEntity.ok(customerService.getMySelf(userId));
    }
}
