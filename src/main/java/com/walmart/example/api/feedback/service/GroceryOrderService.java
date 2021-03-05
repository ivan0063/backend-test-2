package com.walmart.example.api.feedback.service;

import com.walmart.example.api.feedback.dto.GroceryOrderDTO;
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
    /**
     * <p>Method to create a new GROCERY ORDER for an USER but only
     * if the user exist</p>
     * @param userId
     * @param groceryOrderDTO
     * @return ResponseEntity< ResponseDTO | ErrorDTO >
     */
    ResponseEntity createGroceryOrder(Integer userId, GroceryOrderDTO groceryOrderDTO);
}
