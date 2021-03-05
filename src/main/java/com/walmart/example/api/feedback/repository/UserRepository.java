package com.walmart.example.api.feedback.repository;

import com.walmart.example.api.feedback.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>Repository to manage the persistence in the database for the ENTITY User</p>
 *
 * @author J. Ivan Martinez Mateos
 * @since 05/03/2021
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
