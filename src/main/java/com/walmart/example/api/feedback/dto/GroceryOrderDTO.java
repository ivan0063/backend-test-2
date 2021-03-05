package com.walmart.example.api.feedback.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>DTO to retrieve the GroceryOrder entity information</p>
 *
 * @author J. Ivan Martinez Mateos
 * @since 03/03/2021
 */
@Data
public class GroceryOrderDTO implements Serializable {
    @NotNull(message = "Shipping Address should be present in the request")
    @NotBlank(message = "Shipping Address should be present in the request")
    private String shippingAddress;
    private Date creationDate;
    private FeedbackDTO feedback;
    private List<GroceryItemDTO> groceryItems;
}