package com.walmart.example.api.feedback.repository;

import com.walmart.example.api.feedback.entity.Feedback;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Integer> {
}
