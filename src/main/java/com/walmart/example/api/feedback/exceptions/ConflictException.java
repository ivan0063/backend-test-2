package com.walmart.example.api.feedback.exceptions;

/**
 * <p> Exception to be thrown when there is a conflict on UPDATE/CREATE data </p>
 *
 * @author J. Ivan Martinez Mateos
 * @since 03/03/2021
 */
public class ConflictException extends Exception {
    public ConflictException(String problemType) {
        super("Problem on CREATE/UPDATE the object " + problemType);
    }
}
