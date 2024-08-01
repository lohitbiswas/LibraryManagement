package com.example.LibraryManagement.Repository;

import com.example.LibraryManagement.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}
