package com.walmart.example.api.feedback.repository;

import com.walmart.example.api.feedback.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
