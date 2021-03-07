package com.walmart.example.api.feedback.util;

import com.walmart.example.api.feedback.dto.*;
import com.walmart.example.api.feedback.entity.FeedbackUserItem;
import com.walmart.example.api.feedback.entity.GroceryItemOrder;
import com.walmart.example.api.feedback.entity.GroceryOrder;
import com.walmart.example.api.feedback.repository.GroceryItemOrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ResponseBuilderTest {
    @Mock
    private ModelMapper modelMapper;
    @Mock
    private GroceryItemOrderRepository groceryItemOrderRepository;
    @InjectMocks
    private ResponseBuilder responseBuilder;

    @Test
    public void buildErrorDTOTest() {
        HttpStatus httpStatus = HttpStatus.CONFLICT;
        String message = "some message";

        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setStatus(httpStatus.name());
        errorDTO.setMessage(message);

        assertEquals(errorDTO, responseBuilder.buildErrorDTO(httpStatus, message));
    }

    @Test
    public void buildResponseTest() {
        GroceryOrder groceryOrder = new GroceryOrder();
        GroceryOrderDTO groceryOrderDTO = new GroceryOrderDTO();
        groceryOrder.setGroceryItemOrder(Arrays.asList(new GroceryItemOrder[] {}));

        ResponseDTO response = Mockito.mock(ResponseDTO.class);

        when(groceryItemOrderRepository.findAllByGroceryOrder(Mockito.any(GroceryOrder.class)))
                .thenReturn(Arrays.asList(new GroceryItemOrder[] {}));
        when(response.getGroceryOrder()).thenReturn(groceryOrderDTO);
        when(modelMapper.map(Mockito.any(), Mockito.any(Class.class))).thenReturn(response);

        assertEquals(response, responseBuilder.buildResponse(groceryOrder));
    }

    @Test
    public void buildItemFeedbackResponse() {
        FeedbackUserItem feedbackUserItem = new FeedbackUserItem();

        ResponseItemFeedbackDTO responseItemFeedbackDTO = new ResponseItemFeedbackDTO();
        when(modelMapper.map(Mockito.any(), Mockito.any(Class.class))).thenReturn(responseItemFeedbackDTO);

        assertEquals(responseItemFeedbackDTO, responseBuilder.buildItemFeedbackResponse(feedbackUserItem));
    }
}
