package com.walmart.example.api.feedback.controller;

import com.walmart.example.api.feedback.dto.FeedbackDTO;
import com.walmart.example.api.feedback.service.FeedbackItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>Rest Controller class to set Feedback to items</p>
 *
 * @author J. Ivan Martinez Mateos
 * @since 05/03/2021
 */
@RestController
@RequestMapping("api/item/feedback")
public class FeedbackItemController {
    @Autowired
    private FeedbackItemService feedbackItemService;

    @PostMapping("{itemId}")
    public ResponseEntity postFeedbackItem(@PathVariable Integer itemId,
                                           @RequestHeader("userId") Integer userId,
                                           @RequestBody @Valid FeedbackDTO feedbackDTO) {
        return this. feedbackItemService.createFeedbackItem(itemId,userId,feedbackDTO);
    }
}
