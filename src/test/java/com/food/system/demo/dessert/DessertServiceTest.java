package com.food.system.demo.dessert;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DessertServiceTest {

    @Mock
    private DessertRepository dessertRepository;

    @InjectMocks
    private DessertService dessertService;

    @Test
    public void testGetAllDeserts() {
        //given
        Dessert dessert1 = Dessert.builder().name("DessertStub1").price(1).build();
        Dessert dessert2 = Dessert.builder().name("DessertStub2").price(1).build();
        List<Dessert> dessertList = Arrays.asList(dessert1, dessert2);

        when(dessertRepository.findAll()).thenReturn(dessertList);

        //when
        List<Dessert> result = dessertService.getAllDesserts();

        //then
        assertEquals(2, result.size());
        assertEquals("DessertStub1", result.get(0).getName());
        assertEquals("DessertStub2", result.get(1).getName());
    }

    @Test
    public void testGetDessertById() {
        //given
        long dessertId = 0L;
        Dessert dessert = Dessert.builder().name("DessertStub1").price(1).build();

        when(dessertRepository.findById(dessertId)).thenReturn(Optional.of(dessert));

        //when
        Dessert result = dessertService.getDessertById(dessertId);

        //then
        assertEquals(dessertId, result.getId());
        assertEquals("DessertStub1", result.getName());
    }

    @Test
    public void testGetDessertByIdNotFound() {
        //given
        long dessertId = 1L;

        when(dessertRepository.findById(dessertId)).thenReturn(Optional.empty());

        //then
        assertThrows(RuntimeException.class, () -> dessertService.getDessertById(dessertId));
    }

    @Test
    public void testCreateDesert() {
        //given
        Dessert dessertToCreate = Dessert.builder().name("DessertStub1").price(1).build();
        Dessert createdDessert = Dessert.builder().name("DessertStub1").price(1).build();

        when(dessertRepository.save(dessertToCreate)).thenReturn(createdDessert);

        //when
        Dessert result = dessertService.createDessert(dessertToCreate);

        //then
        assertEquals(0L, result.getId());
        assertEquals("DessertStub1", result.getName());
    }
}