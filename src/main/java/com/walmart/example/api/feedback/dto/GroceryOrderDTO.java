package com.walmart.example.api.feedback.dto;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>DTO to retrieve the GroceryOrder entity information</p>
 *
 * @author J. Ivan Martinez Mateos
 * @since 03/03/2021
 */
@Data
public class GroceryOrderDTO implements Serializable {
    private String shippingAddress;
    private Date creationDate;
    private FeedbackDTO feedback;
}