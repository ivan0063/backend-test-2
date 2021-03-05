package com.walmart.example.api.feedback.util;

import com.walmart.example.api.feedback.dto.ErrorDTO;
import com.walmart.example.api.feedback.dto.GroceryItemDTO;
import com.walmart.example.api.feedback.dto.GroceryOrderDTO;
import com.walmart.example.api.feedback.dto.ResponseDTO;
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
     * since it has all the information required </p>
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
}
