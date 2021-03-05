package com.walmart.example.api.feedback.service.implementations;

import com.walmart.example.api.feedback.dto.GroceryOrderDTO;
import com.walmart.example.api.feedback.entity.GroceryOrder;
import com.walmart.example.api.feedback.entity.User;
import com.walmart.example.api.feedback.exceptions.EntityNotFoundException;
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

@Component
public class GroceryOrderServiceImpl implements GroceryOrderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FeedbackOrderServiceImpl.class);
    private GroceryOrderRepository groceryOrderRepository;
    private UserRepository userRepository;
    private ResponseBuilder responseBuilder;

    @Autowired
    public GroceryOrderServiceImpl(GroceryOrderRepository groceryOrderRepository, UserRepository userRepository, ResponseBuilder responseBuilder) {
        this.groceryOrderRepository = groceryOrderRepository;
        this.userRepository = userRepository;
        this.responseBuilder = responseBuilder;
    }

    @Override
    public ResponseEntity createGroceryOrder(Integer userId, GroceryOrderDTO groceryOrderDTO) {
        LOGGER.info("CREATING GROCERY_ORDER");
        ResponseEntity response;

        try {
            User u = userRepository.findById(userId)
                    .orElseThrow(EntityNotFoundException::new);

            GroceryOrder groceryOrder = new GroceryOrder();
            groceryOrder.setShippingAddress(groceryOrderDTO.getShippingAddress());
            groceryOrder.setUser(u);

            groceryOrder = groceryOrderRepository.save(groceryOrder);

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
