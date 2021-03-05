package com.walmart.example.api.feedback.exceptions;

/**
 * <p> Exception to be thrown when an ENTITY could´t be found in the database</p>
 *
 * @author J. Ivan Martinez Mateos
 * @since 03/03/2021
 */
public class EntityNotFoundException extends Exception{
    public EntityNotFoundException(String tableName) {
        super("The entity(s) " + tableName + " could not be found in the database");
    }
}