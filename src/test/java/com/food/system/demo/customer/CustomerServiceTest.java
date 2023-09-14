package com.food.system.demo.customer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    public void testCreateMyself() {
        //given
        Customer customerToSave = new Customer();
        customerToSave.setName("ADMIN");

        Customer savedCustomer = new Customer();
        savedCustomer.setId(1L);
        savedCustomer.setName("ADMIN");

        when(customerRepository.save(customerToSave)).thenReturn(savedCustomer);

        //when
        Customer result = customerService.createMyself(customerToSave);

        //then
        assertEquals(1L, result.getId());
        assertEquals("ADMIN", result.getName());
    }

    @Test
    public void testGetMySelf() {
        //given
        long customerId = 1L;
        Customer customer = new Customer();
        customer.setId(customerId);
        customer.setName("ADMIN");

        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));

        //when
        Customer result = customerService.getMySelf(customerId);

        //then
        assertEquals(1L, result.getId());
        assertEquals("ADMIN", result.getName());
    }

    @Test
    public void testGetMySelfNotFound() {
        //given
        long customerId = 1L;

        when(customerRepository.findById(customerId)).thenReturn(Optional.empty());

        //then
        assertThrows(RuntimeException.class, () -> customerService.getMySelf(customerId));
    }
}