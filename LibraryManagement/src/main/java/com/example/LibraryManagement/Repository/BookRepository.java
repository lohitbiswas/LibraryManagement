package com.example.LibraryManagement.Repository;


import com.example.LibraryManagement.Entity.BookModel;
//import com.example.library.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<BookModel, String> {
}
