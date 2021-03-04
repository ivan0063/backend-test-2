package com.walmart.example.api.feedback.repository;

import com.walmart.example.api.feedback.entity.GroceryOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * <p>Repository to manage the persistence in the database for the ENTITY GroceryOrder</p>
 *
 * @author J. Ivan Martinez Mateos
 * @since 02/03/2021
 */
@Repository
public interface GroceryOrderRepository extends CrudRepository<GroceryOrder, Integer> {
    @Query("SELECT go FROM GROCERY_ORDER go WHERE go.id_grocery_order = ?1 and go.id_user = ?2")
    Optional<GroceryOrder> findByOrderIdAndUserId(Integer orderId, Integer userId);
}
