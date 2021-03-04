package com.walmart.example.api.feedback.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * <p>Class to manage the grocery orders of a client</p>
 *
 * @author J. Ivan Martinez Mateos
 * @since 04/03/2021
 */
@Service
public interface GroceryOrderService {
    ResponseEntity createGroceryOrder(Integer orderId );

    ResponseEntity readGroceryOrder(Integer orderId, Integer userId);

    ResponseEntity editGroceryOrder(Integer orderId);

    ResponseEntity deleteGroceryOrder(Integer orderId);
}
