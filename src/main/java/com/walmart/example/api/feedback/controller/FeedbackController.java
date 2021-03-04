package com.walmart.example.api.feedback.controller;

import com.walmart.example.api.feedback.dto.FeedbackDTO;
import com.walmart.example.api.feedback.service.FeedbackOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <p>Rest Controller class to manage the feedback for the Grocery Orders</p>
 *
 * @author J. Ivan Martinez Mateos
 * @since 04/03/2021
 */
@RestController
@RequestMapping("api/order/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackOrderService feedbackOrderService;

    @GetMapping("{orderId}")
    public ResponseEntity getFeedback(@PathVariable Integer orderId) {
        return feedbackOrderService.readFeedback(orderId);
    }

    @PostMapping("{orderId}")
    public ResponseEntity postFeedback(@RequestBody FeedbackDTO feedbackDTO, @PathVariable Integer orderId) {
        return feedbackOrderService.createFeedback(orderId, feedbackDTO);
    }

    @PutMapping("{orderId}")
    public ResponseEntity putFeedback(@PathVariable Integer orderId, @RequestBody FeedbackDTO feedbackDTO) {
        return feedbackOrderService.editFeedback(orderId, feedbackDTO);
    }

    @DeleteMapping("{orderId}")
    public ResponseEntity deleteFeedback(@PathVariable Integer orderId) {
        return feedbackOrderService.deleteFeedback(orderId);
    }
}
