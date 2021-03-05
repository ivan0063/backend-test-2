package com.walmart.example.api.feedback.repository;

import com.walmart.example.api.feedback.entity.GroceryItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>Repository to manage the persistence in the database for the ENTITY GroceryItem</p>
 *
 * @author J. Ivan Martinez Mateos
 * @since 05/03/2021
 */
@Repository
public interface GroceryItemRepository extends CrudRepository<GroceryItem, Integer> {
}
