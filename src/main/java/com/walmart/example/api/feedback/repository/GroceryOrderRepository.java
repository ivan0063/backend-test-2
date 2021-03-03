package com.walmart.example.api.feedback.repository;

import com.walmart.example.api.feedback.entity.GroceryOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroceryOrderRepository extends CrudRepository<GroceryOrder, Integer> {
}
