package com.walmart.example.api.feedback.service.implementations;

import com.walmart.example.api.feedback.dto.RequestGroceryOrderDTO;
import com.walmart.example.api.feedback.entity.GroceryItemOrder;
import com.walmart.example.api.feedback.entity.GroceryOrder;
import com.walmart.example.api.feedback.entity.User;
import com.walmart.example.api.feedback.exceptions.EntityNotFoundException;
import com.walmart.example.api.feedback.repository.GroceryItemOrderRepository;
import com.walmart.example.api.feedback.repository.GroceryItemRepository;
import com.walmart.example.api.feedback.repository.GroceryOrderRepository;
import com.walmart.example.api.feedback.repository.UserRepository;
import com.walmart.example.api.feedback.service.GroceryOrderService;
import com.walmart.example.api.feedback.util.ResponseBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class GroceryOrderServiceImpl implements GroceryOrderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FeedbackOrderServiceImpl.class);
    private UserRepository userRepository;
    private GroceryOrderRepository groceryOrderRepository;
    private GroceryItemRepository groceryItemRepository;
    private GroceryItemOrderRepository groceryItemOrderRepository;
    private ResponseBuilder responseBuilder;

    @Autowired
    public GroceryOrderServiceImpl(UserRepository userRepository, GroceryOrderRepository groceryOrderRepository,
                                   GroceryItemRepository groceryItemRepository, GroceryItemOrderRepository groceryItemOrderRepository,
                                   ResponseBuilder responseBuilder) {
        this.userRepository = userRepository;
        this.groceryOrderRepository = groceryOrderRepository;
        this.groceryItemRepository = groceryItemRepository;
        this.groceryItemOrderRepository = groceryItemOrderRepository;
        this.responseBuilder = responseBuilder;
    }

    @Override
    public ResponseEntity createGroceryOrder(Integer userId, RequestGroceryOrderDTO groceryOrderDTO) {
        LOGGER.info("CREATING GROCERY_ORDER");
        ResponseEntity response;

        try {
            // Looking for the user to be related with the order
            User u = userRepository.findById(userId)
                    .orElseThrow(() -> new EntityNotFoundException("USER"));

            // Create and persist the new grocery order
            GroceryOrder groceryOrder = new GroceryOrder();
            groceryOrder.setShippingAddress(groceryOrderDTO.getShippingAddress());
            groceryOrder.setUser(u);
            GroceryOrder savedGroceryOrder = groceryOrderRepository.save(groceryOrder);

            // Now Looking for the items in the list and get its objects
            List<GroceryItemOrder> groceryItemOrders = groceryOrderDTO.getGroceryItemsId().stream()
                    .map(groceryItemId -> groceryItemRepository.findById(groceryItemId))
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .map(groceryItem -> {
                        // Once the groceryItems have been retrived, set item by item and save into GroceryItemOrder
                        GroceryItemOrder groceryItemOrder = new GroceryItemOrder();
                        groceryItemOrder.setGroceryOrder(savedGroceryOrder);
                        groceryItemOrder.setGroceryItem(groceryItem);
                        return groceryItemOrder;
                    })
                    .collect(Collectors.toList());

            // Validation in case the list of items weren´t in the data base
            if(!groceryItemOrders.isEmpty()) {
                groceryItemOrderRepository.saveAll(groceryItemOrders);
            } else {
                throw new EntityNotFoundException("GROCERY_ITEM");
            }

            response = ResponseEntity.status(HttpStatus.CREATED)
                    .body(responseBuilder.buildResponse(groceryOrder));
        } catch (EntityNotFoundException e) {
            LOGGER.error("Failed with the next message: " + e.getMessage());
            response = ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(responseBuilder.buildErrorDTO(HttpStatus.CONFLICT, e.getMessage()));
        }

        return response;
    }
}
