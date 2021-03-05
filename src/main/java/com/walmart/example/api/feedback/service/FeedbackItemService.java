package com.walmart.example.api.feedback.service;

import com.walmart.example.api.feedback.dto.FeedbackDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * <p>Service to manage the Feedback - Items interaction</p>
 *
 * @author J. Ivan Martinez Mateos
 * @since 05/03/2021
 */
@Service
public interface FeedbackItemService {
    /**
     * <p>Method to create a feedback for an existing item it retrives an error if any the User and Item
     * could't be found in the database, </p>
     *
     * @param userId
     * @param itemId
     * @param feedbackDTO
     * @return ResponseEntity < ResponseItemFeedbackDTO | ErrorDTO >
     */
    ResponseEntity createFeedbackItem(Integer userId, Integer itemId, FeedbackDTO feedbackDTO);
}
