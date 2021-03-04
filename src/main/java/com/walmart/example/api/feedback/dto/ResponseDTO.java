package com.walmart.example.api.feedback.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>DTO to retrieve a response object</p>
 *
 * @author J. Ivan Martinez Mateos
 * @since 03/03/2021
 */
@Data
public class ResponseDTO implements Serializable {
    private UserDTO user;
    private GroceryOrderDTO groceryOrder;
}
