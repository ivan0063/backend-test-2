package com.walmart.example.api.feedback.repository;

import com.walmart.example.api.feedback.entity.Feedback;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>Repository to manage the persistence in the database for the ENTITY Feedback</p>
 *
 * @author J. Ivan Martinez Mateos
 * @since 02/03/2021
 */
@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Integer> {
    List<Feedback> findAllByOrderByCreatedDesc();

    List<Feedback> findAllByRateOrderByCreatedDesc(Integer rate);
}
