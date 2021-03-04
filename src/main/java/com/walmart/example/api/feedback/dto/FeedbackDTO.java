package com.walmart.example.api.feedback.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>DTO to retrieve the Feedback entity information</p>
 *
 * @author J. Ivan Martinez Mateos
 * @since 03/03/2021
 */
@Data
public class FeedbackDTO implements Serializable {
    private Integer rate;
    private String comment;
}