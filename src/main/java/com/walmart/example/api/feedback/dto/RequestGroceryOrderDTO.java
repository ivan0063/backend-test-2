package com.walmart.example.api.feedback.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>DTO to retrieve the Grocery Order entity information</p>
 *
 * @author J. Ivan Martinez Mateos
 * @since 05/03/2021
 */
@Data
public class RequestGroceryOrderDTO extends GroceryOrderDTO{
    @NotNull(message = "Grocery items should be present in the request")
    @NotEmpty(message = "Grocery order must have at least one item")
    private List<Integer> groceryItemsId;
}
