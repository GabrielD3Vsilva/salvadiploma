package com.salvadiploma.salvadiploma.repository;

import com.salvadiploma.salvadiploma.model.User;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoginRepository extends MongoRepository<User, String> {
    User findByName(String name);
}