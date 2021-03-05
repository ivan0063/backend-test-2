package com.walmart.example.api.feedback.util;

import com.walmart.example.api.feedback.dto.*;
import com.walmart.example.api.feedback.entity.FeedbackUserItem;
import com.walmart.example.api.feedback.entity.GroceryItemOrder;
import com.walmart.example.api.feedback.entity.GroceryOrder;
import com.walmart.example.api.feedback.repository.GroceryItemOrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>Bean to build the main responses</p>
 *
 * @author J. Ivan Martinez Mateos
 * @since 04/04/2021
 */
@Component
public class ResponseBuilder {
    private ModelMapper modelMapper;
    private GroceryItemOrderRepository groceryItemOrderRepository;

    @Autowired
    public ResponseBuilder(ModelMapper modelMapper, GroceryItemOrderRepository groceryItemOrderRepository) {
        this.modelMapper = modelMapper;
        this.groceryItemOrderRepository = groceryItemOrderRepository;
    }

    /**
     * <p>Method to build an Error response with a personalized http status and message</p>
     *
     * @param httpStatus HttpStatus
     * @param message String
     * @return ErrorDTO
     */
    public ErrorDTO buildErrorDTO(HttpStatus httpStatus, String message) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setStatus(httpStatus.name());
        errorDTO.setMessage(message);

        return errorDTO;
    }

    /**
     * <p>Method to build a ResponseDTO using the bean ModelMapper from the entity GroceryOrder,
     * since it has all the information required, also it retreive all the items that belong to
     * the GroceryOrder and map into its respective DTO</p>
     *
     * @param groceryOrder
     * @return ResponseDTO
     */
    public ResponseDTO buildResponse(GroceryOrder groceryOrder) {
        List<GroceryItemDTO> groceryItems = groceryItemOrderRepository.findAllByGroceryOrder(groceryOrder)
                .stream()
                .map(GroceryItemOrder::getGroceryItem)
                .map(groceryItem -> this.modelMapper.map(groceryItem, GroceryItemDTO.class))
                .collect(Collectors.toList());

        ResponseDTO response = modelMapper.map(groceryOrder, ResponseDTO.class);
        response.getGroceryOrder().setGroceryItems(groceryItems);
        return response;
    }

    /**
     * <p>Method to build a ResponseItemFeedbackDTO using the bean ModelMapper from the entity FeedbackUserItem
     * since it has all the information</p>
     *
     * @param feedbackUserItem
     * @return ResponseItemFeedbackDTO
     */
    public ResponseItemFeedbackDTO buildItemFeedbackResponse(FeedbackUserItem feedbackUserItem) {
        return modelMapper.map(feedbackUserItem, ResponseItemFeedbackDTO.class);
    }
}
