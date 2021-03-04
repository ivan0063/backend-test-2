package com.walmart.example.api.feedback.repository;

import com.walmart.example.api.feedback.entity.GroceryOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
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
    @Query(nativeQuery = true, value = "SELECT * FROM GROCERY_ORDER GO WHERE GO.ID_FEEDBACK = :idFeedback")
    Optional<GroceryOrder> findByIdFeedback(@Param("idFeedback") Integer idFeedback);
}
