package com.walmart.example.api.feedback.repository;

import com.walmart.example.api.feedback.entity.FeedbackUserItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>Repository to manage the persistence in the database for the ENTITY FeedbackUserItem</p>
 *
 * @author J. Ivan Martinez Mateos
 * @since 05/03/2021
 */
@Repository
public interface FeedbackUserItemRepository extends CrudRepository<FeedbackUserItem, Integer> {
}
