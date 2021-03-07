package com.walmart.example.api.feedback.service.implementations;

import com.walmart.example.api.feedback.dto.ErrorDTO;
import com.walmart.example.api.feedback.dto.FeedbackDTO;
import com.walmart.example.api.feedback.dto.ResponseDTO;
import com.walmart.example.api.feedback.entity.Feedback;
import com.walmart.example.api.feedback.entity.GroceryItem;
import com.walmart.example.api.feedback.entity.GroceryOrder;
import com.walmart.example.api.feedback.entity.User;
import com.walmart.example.api.feedback.repository.FeedbackRepository;
import com.walmart.example.api.feedback.repository.FeedbackUserItemRepository;
import com.walmart.example.api.feedback.repository.GroceryItemRepository;
import com.walmart.example.api.feedback.repository.UserRepository;
import com.walmart.example.api.feedback.util.ResponseBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class FeedbackItemSeriveImplTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private GroceryItemRepository groceryItemRepository;
    @Mock
    private FeedbackRepository feedbackRepository;
    @Mock
    private FeedbackUserItemRepository feedbackUserItemRepository;
    @Mock
    private ResponseBuilder responseBuilder;
    @InjectMocks
    FeedbackItemServiceImpl feedbackItemService;

    @Test
    public void createFeedbackItemTest() {
        //Variables
        User user = new User();
        Optional<User> userOpt = Optional.ofNullable(user);
        GroceryItem groceryItem = new GroceryItem();
        Optional<GroceryItem> groceryOrderOpt = Optional.ofNullable(groceryItem);
        Feedback feedback = new Feedback();
        ResponseDTO responseDTO = new ResponseDTO();
        FeedbackDTO feedbackDTO = new FeedbackDTO();

        // Defining rules
        when(userRepository.findById(Mockito.anyInt())).thenReturn(userOpt);
        when(groceryItemRepository.findById(Mockito.anyInt())).thenReturn(groceryOrderOpt);
        when(feedbackRepository.save(Mockito.any(Feedback.class))).thenReturn(feedback);
        when(responseBuilder.buildResponse(Mockito.any(GroceryOrder.class))).thenReturn(responseDTO);

        ResponseEntity<ResponseDTO> method = feedbackItemService.createFeedbackItem(1,1,feedbackDTO);
        ResponseEntity<ResponseDTO>  a = ResponseEntity.status(HttpStatus.CREATED).build();
        assertEquals(a, method);
    }

    @Test
    public void createFeedbackItemTestFailUser() {
        // Variables
        FeedbackDTO feedbackDTO = new FeedbackDTO();

        // Defining rules send a null on user retrieve
        when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(null));

        ResponseEntity<ErrorDTO> method = feedbackItemService.createFeedbackItem(1,1,feedbackDTO);
        ResponseEntity<ErrorDTO>  errorDTOResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        assertEquals(errorDTOResponseEntity, method);
    }

    @Test
    public void createFeedbackItemTestFailItem() {
        // Variables
        FeedbackDTO feedbackDTO = new FeedbackDTO();
        User user = new User();

        // Defining rules send a null on user retrieve
        when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(user));
        when(groceryItemRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(null));

        ResponseEntity<ErrorDTO> method = feedbackItemService.createFeedbackItem(1,1,feedbackDTO);
        ResponseEntity<ErrorDTO>  errorDTOResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        assertEquals(errorDTOResponseEntity, method);
    }
}
