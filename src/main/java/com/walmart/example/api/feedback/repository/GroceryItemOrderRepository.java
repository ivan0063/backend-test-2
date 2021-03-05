package com.walmart.example.api.feedback.repository;

import com.walmart.example.api.feedback.entity.GroceryItemOrder;
import com.walmart.example.api.feedback.entity.GroceryOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroceryItemOrderRepository extends CrudRepository<GroceryItemOrder, Integer> {
    List<GroceryItemOrder> findAllByGroceryOrder(GroceryOrder groceryOrder);
}
