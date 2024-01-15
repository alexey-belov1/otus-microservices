package com.otus.microservices.repository;

import com.otus.microservices.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
