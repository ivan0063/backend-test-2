package com.walmart.example.api.feedback.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>DTO to retrieve the Feedback entity information</p>
 *
 * @author J. Ivan Martinez Mateos
 * @since 03/03/2021
 */
@Data
public class FeedbackDTO implements Serializable {
    @NotNull(message = "Rate should be present in the request")
    @Min(value = 1, message = "Rate should not be less the 1")
    @Max(value = 5, message = "Rate should not be grater than 5")
    private Integer rate;
    @NotNull
    @NotBlank(message = "Rate should be present in the request")
    private String comment;
}