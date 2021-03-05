package com.walmart.example.api.feedback.exceptions;

/**
 * <p> Exception to be thrown when the rate provided to filter the results of the latest feedback its
 * out of range</p>
 *
 * @author J. Ivan Martinez Mateos
 * @since 05/03/2021
 */
public class RateOutOfRangeException extends Exception {
    public RateOutOfRangeException() {
        super("The filter is out of range must be between 1 and 5");
    }
}
