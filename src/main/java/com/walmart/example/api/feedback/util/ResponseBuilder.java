package com.walmart.example.api.feedback.util;

import com.walmart.example.api.feedback.dto.ErrorDTO;
import com.walmart.example.api.feedback.dto.ResponseDTO;
import com.walmart.example.api.feedback.entity.GroceryOrder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * <p>Bean to build the main responses</p>
 *
 * @author J. Ivan Martinez Mateos
 * @since 04/04/2021
 */
@Component
public class ResponseBuilder {
    @Autowired
    private ModelMapper modelMapper;

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
        return modelMapper.map(groceryOrder, ResponseDTO.class);
    }
}
