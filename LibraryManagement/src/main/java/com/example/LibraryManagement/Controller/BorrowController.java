package com.example.LibraryManagement.Controller;

import com.example.LibraryManagement.Entity.Borrow;
import com.example.LibraryManagement.Service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrows")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @GetMapping("/user/{userId}")
    public List<Borrow> getBorrowsByUserId(@PathVariable String userId) {
        return borrowService.getBorrowsByUserId(userId);
    }

    @PostMapping("/{bookId}/borrow")
    public Borrow borrowBook(@RequestParam String userId, @PathVariable String bookId) {
        return borrowService.borrowBook(userId, bookId);
    }

    @PostMapping("/{bookId}/return")
    public Borrow returnBook(@RequestParam String userId, @PathVariable String bookId) {
        return borrowService.returnBook(userId, bookId);
    }
}
