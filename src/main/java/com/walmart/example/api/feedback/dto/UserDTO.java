package com.walmart.example.api.feedback.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>DTO to retrieve the User entity information</p>
 *
 * @author J. Ivan Martinez Mateos
 * @since 03/03/2021
 */
@Data
public class UserDTO implements Serializable {
    private String fullName;
    private String email;
}
