package com.walmart.example.api.feedback.controller;

import com.walmart.example.api.feedback.dto.RequestGroceryOrderDTO;
import com.walmart.example.api.feedback.service.GroceryOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>Rest Controller class to create new Grocery orders</p>
 *
 * @author J. Ivan Martinez Mateos
 * @since 04/03/2021
 */
@RestController
@RequestMapping("api/order")
public class GroceryOrderController {
    @Autowired
    private GroceryOrderService groceryOrderService;

    @PostMapping
    public ResponseEntity postGroceryOrder(@RequestHeader("userId") Integer userId,
                                           @RequestBody @Valid RequestGroceryOrderDTO groceryOrder) {
        return groceryOrderService.createGroceryOrder(userId, groceryOrder);
    }
}
