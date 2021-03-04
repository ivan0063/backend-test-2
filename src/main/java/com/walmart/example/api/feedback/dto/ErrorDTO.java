package com.walmart.example.api.feedback.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>DTO to retrieve a error response </p>
 *
 * @author J. Ivan Martinez Mateos
 * @since 03/03/2021
 */
@Data
public class ErrorDTO implements Serializable {
    private String status;
    private String message;
}
