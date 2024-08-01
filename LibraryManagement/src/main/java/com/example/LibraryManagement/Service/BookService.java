package com.example.LibraryManagement.Service;



import com.example.LibraryManagement.Entity.BookModel;
import com.example.LibraryManagement.Repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookModel> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<BookModel> getBookById(String id) {
        return bookRepository.findById(id);
    }

    public BookModel addBook(BookModel book) {
        book.setAvailable(true);
        return bookRepository.save(book);
    }

    public BookModel updateBook(String id, BookModel book) {
        book.setId(id);
        return bookRepository.save(book);
    }

    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }
}

