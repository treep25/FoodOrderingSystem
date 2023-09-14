package com.food.system.demo.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer createMyself(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getMySelf(long id) {
        return customerRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
