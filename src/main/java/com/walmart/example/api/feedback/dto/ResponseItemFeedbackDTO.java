package com.walmart.example.api.feedback.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>DTO to retrieve a response object for the Item-Feedback service</p>
 *
 * @author J. Ivan Martinez Mateos
 * @since 05/03/2021
 */
@Data
public class ResponseItemFeedbackDTO extends GroceryItemDTO implements Serializable {
    private UserDTO user;
}
