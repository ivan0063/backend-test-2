package com.walmart.example.api.feedback.service.implementations;

import com.walmart.example.api.feedback.dto.FeedbackDTO;
import com.walmart.example.api.feedback.entity.Feedback;
import com.walmart.example.api.feedback.entity.GroceryOrder;
import com.walmart.example.api.feedback.repository.FeedbackRepository;
import com.walmart.example.api.feedback.repository.GroceryOrderRepository;
import com.walmart.example.api.feedback.util.ResponseBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class FeedbackOrderServiceImplTest {
    @Mock
    FeedbackRepository feedbackRepository;
    @Mock
    GroceryOrderRepository groceryOrderRepository;
    @Mock
    ResponseBuilder responseBuilder;
    @InjectMocks
    FeedbackOrderServiceImpl feedbackOrderService;

    @Test
    public void createTestPassed() {
        // Variables
        GroceryOrder groceryOrder = new GroceryOrder();
        FeedbackDTO feedbackDTO = new FeedbackDTO();

        // Rules
        when(groceryOrderRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(groceryOrder));

        // Asserts
        ResponseEntity createFeedback = feedbackOrderService.createFeedback(1, feedbackDTO);
        ResponseEntity createFeedbackB = ResponseEntity.status(HttpStatus.CREATED).build();

        assertEquals(createFeedbackB, createFeedback);
    }

    @Test
    public void createTestFailNoFeedbackNotGroceryOrder() {
        // Variables
        FeedbackDTO feedbackDTO = new FeedbackDTO();

        // Rules
        when(groceryOrderRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(null));

        // Asserts
        ResponseEntity createFeedback = feedbackOrderService.createFeedback(1, feedbackDTO);
        ResponseEntity createFeedbackB = ResponseEntity.status(HttpStatus.CONFLICT).build();

        assertEquals(createFeedbackB, createFeedback);
    }

    @Test
    public void createTestFailFeedbackOnGroceryOrder() {
        // Variables
        FeedbackDTO feedbackDTO = new FeedbackDTO();
        GroceryOrder groceryOrder = Mockito.mock(GroceryOrder.class);

        // Rules
        when(groceryOrderRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(groceryOrder));
        when(groceryOrder.getFeedback()).thenReturn(new Feedback());

        // Asserts
        ResponseEntity createFeedback = feedbackOrderService.createFeedback(1, feedbackDTO);
        ResponseEntity createFeedbackB = ResponseEntity.status(HttpStatus.CONFLICT).build();

        assertEquals(createFeedbackB, createFeedback);
    }

    @Test
    public void allTestPassFeedback() {
        // Variables
        GroceryOrder groceryOrder = Mockito.mock(GroceryOrder.class);
        Feedback feedback = Mockito.mock(Feedback.class);
        FeedbackDTO feedbackDTO = Mockito.mock(FeedbackDTO.class);

        // Rules
        when(groceryOrderRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(groceryOrder));
        when(groceryOrder.getFeedback()).thenReturn(feedback);

        // Asserts
        ResponseEntity deleteFeedback = feedbackOrderService.deleteFeedback(1);
        ResponseEntity editFeedback = feedbackOrderService.editFeedback(1, feedbackDTO);
        ResponseEntity readFeedback = feedbackOrderService.readFeedback(1);

        ResponseEntity deleteFeedbackB = ResponseEntity.status(HttpStatus.OK).build();
        ResponseEntity editFeedbackB = ResponseEntity.status(HttpStatus.OK).build();
        ResponseEntity readFeedbackB = ResponseEntity.status(HttpStatus.OK).build();

        assertEquals(deleteFeedbackB, deleteFeedback);
        assertEquals(editFeedbackB, editFeedback);
        assertEquals(readFeedbackB, readFeedback);
    }

    @Test
    public void allTestPassFeedbackNoOrder() {
        // Variables
        FeedbackDTO feedbackDTO = Mockito.mock(FeedbackDTO.class);

        // Rules
        when(groceryOrderRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(null));

        // Asserts
        ResponseEntity deleteFeedback = feedbackOrderService.deleteFeedback(1);
        ResponseEntity editFeedback = feedbackOrderService.editFeedback(1, feedbackDTO);
        ResponseEntity readFeedback = feedbackOrderService.readFeedback(1);

        ResponseEntity deleteFeedbackB = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        ResponseEntity editFeedbackB = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        ResponseEntity readFeedbackB = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        assertEquals(deleteFeedbackB, deleteFeedback);
        assertEquals(editFeedbackB, editFeedback);
        assertEquals(readFeedbackB, readFeedback);
    }

    @Test
    public void deleteTestFailFeedbackNull() {
        // Variables
        GroceryOrder groceryOrder = Mockito.mock(GroceryOrder.class);
        FeedbackDTO feedbackDTO = Mockito.mock(FeedbackDTO.class);

        // Rules
        when(groceryOrderRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(groceryOrder));

        // Asserts
        ResponseEntity editFeedback = feedbackOrderService.editFeedback(1, feedbackDTO);
        ResponseEntity editFeedbackB = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        assertEquals(editFeedbackB, editFeedback);
    }
}
