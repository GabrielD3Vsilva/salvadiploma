package com.salvadiploma.salvadiploma.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import com.salvadiploma.salvadiploma.model.User;

public interface RegisterRepository extends MongoRepository<User, String> {
    
}

