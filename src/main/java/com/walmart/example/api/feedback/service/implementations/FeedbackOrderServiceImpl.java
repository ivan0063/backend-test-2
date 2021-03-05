package com.walmart.example.api.feedback.service.implementations;

import com.walmart.example.api.feedback.dto.FeedbackDTO;
import com.walmart.example.api.feedback.dto.ResponseDTO;
import com.walmart.example.api.feedback.entity.Feedback;
import com.walmart.example.api.feedback.entity.GroceryOrder;
import com.walmart.example.api.feedback.exceptions.ConflictException;
import com.walmart.example.api.feedback.exceptions.EntityNotFoundException;
import com.walmart.example.api.feedback.exceptions.RateOutOfRangeException;
import com.walmart.example.api.feedback.repository.FeedbackRepository;
import com.walmart.example.api.feedback.repository.GroceryOrderRepository;
import com.walmart.example.api.feedback.service.FeedbackOrderService;
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

/**
 * <p>FeedbackOrderService Implementation</p>
 *
 * @author J. Ivan Martinez Mateos
 * @since 03/03/2021
 */
@Component
public class FeedbackOrderServiceImpl implements FeedbackOrderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FeedbackOrderServiceImpl.class);
    private FeedbackRepository feedbackRepository;
    private GroceryOrderRepository groceryOrderRepository;
    private ResponseBuilder responseBuilder;

    @Autowired
    public FeedbackOrderServiceImpl(FeedbackRepository feedbackRepository, GroceryOrderRepository groceryOrderRepository,
                                    ResponseBuilder responseBuilder) {
        this.feedbackRepository = feedbackRepository;
        this.groceryOrderRepository = groceryOrderRepository;
        this.responseBuilder = responseBuilder;
    }

    @Override
    public ResponseEntity createFeedback(Integer orderId, FeedbackDTO feedback) {
        LOGGER.info("CRETE");
        ResponseEntity response;
        try {
            LOGGER.info("Making a new feedback, looking for the order");
            GroceryOrder groceryOrder = groceryOrderRepository.findById(orderId)
                    .orElseThrow(() -> new EntityNotFoundException("GROCERY_ORDER"));

            // Validating if the order has already a feedback
            if (groceryOrder.getFeedback() == null) {
                Feedback nFeedback = new Feedback();
                nFeedback.setRate(feedback.getRate());
                nFeedback.setComment(feedback.getComment());
                nFeedback.setFlagItem(false);
                nFeedback = feedbackRepository.save(nFeedback);

                groceryOrder.setFeedback(nFeedback);
                groceryOrder = groceryOrderRepository.save(groceryOrder);

                response = ResponseEntity.status(HttpStatus.CREATED)
                        .body(responseBuilder.buildResponse(groceryOrder));
            } else {
                throw new ConflictException("order already has a feedback");
            }
        } catch (EntityNotFoundException | ConflictException e) {
            LOGGER.error("Failed with the next message: " + e.getMessage());
            response = ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(responseBuilder.buildErrorDTO(HttpStatus.CONFLICT, e.getMessage()));
        }

        return response;
    }

    @Override
    public ResponseEntity readFeedback(Integer orderId) {
        LOGGER.info("READ");
        LOGGER.info("looking for a FEEDBACK with the next info: ");
        LOGGER.info("orderID = " + orderId);

        ResponseEntity response;
        try {
            GroceryOrder groceryOrder = groceryOrderRepository.findById(orderId)
                    .orElseThrow(() -> new EntityNotFoundException("GROCERY_ORDER"));
            LOGGER.info("Founded! Making the response");

            response = ResponseEntity.ok(responseBuilder.buildResponse(groceryOrder));
        } catch (EntityNotFoundException e) {
            LOGGER.error("Failed with the next message: " + e.getMessage());

            response = ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(responseBuilder.buildErrorDTO(HttpStatus.NOT_FOUND, e.getMessage()));
        }

        return response;
    }

    @Override
    public ResponseEntity editFeedback(Integer orderId, FeedbackDTO feedbackDTO) {
        LOGGER.info("EDIT");
        LOGGER.info("looking up for a FEEDBACK with the next info: ");
        LOGGER.info("orderID = " + orderId);

        ResponseEntity response;
        try {
            GroceryOrder groceryOrder = groceryOrderRepository.findById(orderId)
                    .orElseThrow(() -> new EntityNotFoundException("GROCERY_ORDER"));
            LOGGER.info("Founded! updating the feedback");

            Feedback oldFeedback = Optional.ofNullable(groceryOrder.getFeedback())
                    .orElseThrow(() -> new ConflictException("order doesn't have a feedback"));
            oldFeedback.setComment(feedbackDTO.getComment());
            oldFeedback.setRate(feedbackDTO.getRate());

            oldFeedback = feedbackRepository.save(oldFeedback);
            groceryOrder.setFeedback(oldFeedback);

            response = ResponseEntity.ok(responseBuilder.buildResponse(groceryOrder));

        } catch (EntityNotFoundException | ConflictException e) {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(responseBuilder.buildErrorDTO(HttpStatus.NOT_FOUND, e.getMessage()));
        }

        return response;
    }

    @Override
    public ResponseEntity deleteFeedback(Integer orderId) {
        LOGGER.info("DELETE");
        LOGGER.info("looking up for a FEEDBACK with the next info: ");
        LOGGER.info("orderID = " + orderId);

        ResponseEntity response;
        try {
            GroceryOrder groceryOrder = groceryOrderRepository.findById(orderId)
                    .orElseThrow(() -> new EntityNotFoundException("GROCERY_ORDER"));
            LOGGER.info("Founded! building the response");
            Feedback delete = groceryOrder.getFeedback();
            groceryOrder.setFeedback(null);

            feedbackRepository.delete(delete);
            groceryOrderRepository.save(groceryOrder);

            response = ResponseEntity.ok(responseBuilder.buildResponse(groceryOrder));
        } catch (EntityNotFoundException e) {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(responseBuilder.buildErrorDTO(HttpStatus.NOT_FOUND, e.getMessage()));
        }

        return response;
    }

    @Override
    public ResponseEntity latestTwentyFeedback(Integer filteringRate) {
        LOGGER.info("LATEST 20 FEEDBACK");
        LOGGER.info("Filter rate " + filteringRate);
        ResponseEntity response;

        try {
            LOGGER.info("Validating the range of the rate...");
            if(filteringRate != -1 && (filteringRate < 1 || filteringRate > 5)) {
                throw new RateOutOfRangeException();
            }

            // Validate if the filterRate has a valid value to filter or give the last 20 without filtering
            List<Feedback> feedbacks = filteringRate == -1 ? feedbackRepository.findAllByOrderByCreatedDesc() :
                    feedbackRepository.findAllByRateOrderByCreatedDesc(filteringRate);

            List<ResponseDTO> latestFeedback = feedbacks.stream()
                    .map(feedback -> groceryOrderRepository.findByIdFeedback(feedback.getIdFeedback()))
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .filter(groceryOrder -> !groceryOrder.getFeedback().getFlagItem())
                    .map(responseBuilder::buildResponse)
                    .collect(Collectors.toList());

            if (latestFeedback.size() > 20) {
                latestFeedback = latestFeedback.subList(0, 20);
            }

            response = ResponseEntity.ok(latestFeedback);
        }catch (RateOutOfRangeException e) {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(responseBuilder.buildErrorDTO(HttpStatus.BAD_REQUEST, e.getMessage()));
        }

        return response;
    }
}