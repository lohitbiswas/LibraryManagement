package com.example.LibraryManagement.Repository;


import com.example.LibraryManagement.Entity.Borrow;
//import com.example.library.entity.Borrow;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BorrowRepository extends MongoRepository<Borrow, String> {
    List<Borrow> findByUserId(String userId);
    List<Borrow> findByBookIdAndReturnDateIsNull(String bookId);
}
