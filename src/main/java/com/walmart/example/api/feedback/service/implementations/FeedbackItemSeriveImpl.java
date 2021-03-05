package com.walmart.example.api.feedback.service.implementations;

import com.walmart.example.api.feedback.dto.FeedbackDTO;
import com.walmart.example.api.feedback.entity.Feedback;
import com.walmart.example.api.feedback.entity.FeedbackUserItem;
import com.walmart.example.api.feedback.entity.GroceryItem;
import com.walmart.example.api.feedback.entity.User;
import com.walmart.example.api.feedback.exceptions.EntityNotFoundException;
import com.walmart.example.api.feedback.repository.FeedbackRepository;
import com.walmart.example.api.feedback.repository.FeedbackUserItemRepository;
import com.walmart.example.api.feedback.repository.GroceryItemRepository;
import com.walmart.example.api.feedback.repository.UserRepository;
import com.walmart.example.api.feedback.service.FeedbackItemService;
import com.walmart.example.api.feedback.util.ResponseBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class FeedbackItemSeriveImpl implements FeedbackItemService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FeedbackItemSeriveImpl.class);
    private UserRepository userRepository;
    private GroceryItemRepository groceryItemRepository;
    private FeedbackRepository feedbackRepository;
    private FeedbackUserItemRepository feedbackUserItemRepository;
    private ResponseBuilder responseBuilder;

    @Autowired
    public FeedbackItemSeriveImpl(UserRepository userRepository, GroceryItemRepository groceryItemRepository,
                                  FeedbackRepository feedbackRepository, FeedbackUserItemRepository feedbackUserItemRepository, ResponseBuilder responseBuilder) {
        this.userRepository = userRepository;
        this.groceryItemRepository = groceryItemRepository;
        this.feedbackRepository = feedbackRepository;
        this.feedbackUserItemRepository = feedbackUserItemRepository;
        this.responseBuilder = responseBuilder;
    }

    @Override
    public ResponseEntity createFeedbackItem(Integer userId, Integer itemId, FeedbackDTO feedbackDTO) {
        LOGGER.info("CREATING FEEDBACK FOR AN ITEM");
        ResponseEntity response;
        try {
            LOGGER.info("Looking for a valid user to continue...");
            User user = userRepository.findById(userId)
                    .orElseThrow(()-> new EntityNotFoundException("USER"));

            LOGGER.info("Done! Looking for the item on the DB...");
            GroceryItem groceryItem = groceryItemRepository.findById(itemId)
                    .orElseThrow(()-> new EntityNotFoundException("GROCERY_ITEM"));

            LOGGER.info("Done! now start the creation of the feedback");
            Feedback feedback = new Feedback();
            feedback.setRate(feedbackDTO.getRate());
            feedback.setComment(feedbackDTO.getComment());
            feedback.setFlagItem(true);
            feedback = feedbackRepository.save(feedback);

            FeedbackUserItem feedbackUserItem = new FeedbackUserItem();
            feedbackUserItem.setFeedback(feedback);
            feedbackUserItem.setGroceryItem(groceryItem);
            feedbackUserItem.setUser(user);
            feedbackUserItem = feedbackUserItemRepository.save(feedbackUserItem);

            response = ResponseEntity.status(HttpStatus.CREATED)
                    .body(responseBuilder.buildItemFeedbackResponse(feedbackUserItem));
        } catch (EntityNotFoundException e){
            LOGGER.error("Failed with the next message: " + e.getMessage());
            response = ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(responseBuilder.buildErrorDTO(HttpStatus.NOT_FOUND, e.getMessage()));
        }

        return response;
    }
}
