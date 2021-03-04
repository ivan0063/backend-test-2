package com.walmart.example.api.feedback.service;

import com.walmart.example.api.feedback.dto.FeedbackDTO;
import org.springframework.http.ResponseEntity;

/**
 * <p>Service to manage the fedback - GroceryOrder interaction</p>
 *
 * @author J. Ivan Martinez Mateos
 * @since 03/03/2021
 */
public interface FeedbackOrderService {
    /**
     * <p>Method to create a new feedback for an Order but only
     * if the order in question hasn't have one yet</p>
     *
     * @param orderId Integer
     * @param feedback FeedbackDTO
     * @return ResponseEntity<ResponseDTO | ErrorDTO>
     */
    ResponseEntity createFeedback(Integer orderId, FeedbackDTO feedback);

    /**
     * <p>Method to get a Feedback with its corresponding GroceryOrder and User
     * information if exist otherwise will return a not found entity error</p>
     *
     * @param orderId Integer
     * @return ResponseEntity<ResponseDTO | ErrorDTO>
     */
    ResponseEntity readFeedback(Integer orderId);

    /**
     * <p>Method to edit the information for a Feedback but only if the GroceryOrder exist
     * and already has a Feedback otherwise will return a conflict error</p>
     *
     * @param orderId Integer
     * @param feedbackDTO FeedbackDTO
     * @return ResponseEntity<ResponseDTO | ErrorDTO>
     */
    ResponseEntity editFeedback(Integer orderId, FeedbackDTO feedbackDTO);

    /**
     * <p>Method to delete a feedback for a GroceryOrder but only if exist otherwise
     * will return a conflict error</p>
     *
     * @param orderId Integer
     * @return ResponseEntity<ResponseDTO | ErrorDTO>
     */
    ResponseEntity deleteFeedback(Integer orderId);
}
