package com.example.bug.tracker.repos;


import com.example.bug.tracker.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User getUserByUserId(Integer id);
}
