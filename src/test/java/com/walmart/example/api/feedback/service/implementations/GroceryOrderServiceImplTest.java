package com.walmart.example.api.feedback.service.implementations;

import com.walmart.example.api.feedback.dto.RequestGroceryOrderDTO;
import com.walmart.example.api.feedback.entity.GroceryItem;
import com.walmart.example.api.feedback.entity.User;
import com.walmart.example.api.feedback.repository.GroceryItemOrderRepository;
import com.walmart.example.api.feedback.repository.GroceryItemRepository;
import com.walmart.example.api.feedback.repository.GroceryOrderRepository;
import com.walmart.example.api.feedback.repository.UserRepository;
import com.walmart.example.api.feedback.util.ResponseBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class GroceryOrderServiceImplTest {
    @Mock
    UserRepository userRepository;
    @Mock
    GroceryOrderRepository groceryOrderRepository;
    @Mock
    GroceryItemRepository groceryItemRepository;
    @Mock
    GroceryItemOrderRepository groceryItemOrderRepository;
    @Mock
    ResponseBuilder responseBuilder;
    @InjectMocks
    private GroceryOrderServiceImpl groceryOrderService;

    @Test
    public void createGroceryOrder() {
        // Variables
        User user = new User();
        GroceryItem groceryItem = new GroceryItem();
        RequestGroceryOrderDTO requestGroceryOrderDTO = new RequestGroceryOrderDTO();
        requestGroceryOrderDTO.setGroceryItemsId(Arrays.asList(new Integer[] {1,2,4,5}));

        // Rules
        when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(user));
        when(groceryItemRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(groceryItem));

        // Asserts
        ResponseEntity responseEntity = groceryOrderService.createGroceryOrder(1,requestGroceryOrderDTO);
        ResponseEntity responseCreated = ResponseEntity.status(HttpStatus.CREATED).build();

        assertEquals(responseCreated, responseEntity);
    }

    @Test
    public void createGroceryOrderFailUser() {
        // Variables
        RequestGroceryOrderDTO requestGroceryOrderDTO = new RequestGroceryOrderDTO();

        // Rules
        when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(null));

        // Asserts
        ResponseEntity responseEntity = groceryOrderService.createGroceryOrder(1,requestGroceryOrderDTO);
        ResponseEntity responseCreated = ResponseEntity.status(HttpStatus.CONFLICT).build();

        assertEquals(responseCreated, responseEntity);
    }

    @Test
    public void createGroceryOrderFailGroceryItem() {
        // Variables
        User user = new User();
        RequestGroceryOrderDTO requestGroceryOrderDTO = new RequestGroceryOrderDTO();
        requestGroceryOrderDTO.setGroceryItemsId(Arrays.asList(new Integer[] {1,2,4,5}));

        // Rules
        when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(user));
        when(groceryItemRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(null));

        // Asserts
        ResponseEntity responseEntity = groceryOrderService.createGroceryOrder(1,requestGroceryOrderDTO);
        ResponseEntity responseCreated = ResponseEntity.status(HttpStatus.CONFLICT).build();

        assertEquals(responseCreated, responseEntity);
    }
}
