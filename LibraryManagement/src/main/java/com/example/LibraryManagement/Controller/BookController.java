package com.example.LibraryManagement.Controller;


import com.example.LibraryManagement.Entity.BookModel;
import com.example.LibraryManagement.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookModel> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public BookModel addBook(@RequestBody BookModel book) {
        return bookService.addBook(book);
    }

    @GetMapping("/{id}")
    public Optional<BookModel> getBookById(@PathVariable String id) {
        return bookService.getBookById(id);
    }

    @PutMapping("/{id}")
    public BookModel updateBook(@PathVariable String id, @RequestBody BookModel book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String id) {
        bookService.deleteBook(id);
    }
}

