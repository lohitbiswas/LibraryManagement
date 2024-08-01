package com.example.LibraryManagement.Service;

import com.example.LibraryManagement.Entity.BookModel;
import com.example.LibraryManagement.Entity.Borrow;
import com.example.LibraryManagement.Repository.BookRepository;
import com.example.LibraryManagement.Repository.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BorrowService {

    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private BookRepository bookRepository;

    public List<Borrow> getBorrowsByUserId(String userId) {
        return borrowRepository.findByUserId(userId);
    }

    public Borrow borrowBook(String userId, String bookId) {
        List<Borrow> existingBorrows = borrowRepository.findByBookIdAndReturnDateIsNull(bookId);
        if (existingBorrows.isEmpty()) {
            Borrow borrow = new Borrow();
            borrow.setUserId(userId);
            borrow.setBookId(bookId);
            borrow.setBorrowDate(LocalDate.now());
            Borrow savedBorrow = borrowRepository.save(borrow);

            BookModel book = bookRepository.findById(bookId).orElseThrow();
            book.setAvailable(false);
            bookRepository.save(book);

            return savedBorrow;
        } else {
            throw new IllegalStateException("Book is already borrowed");
        }
    }

    public Borrow returnBook(String userId, String bookId) {
        List<Borrow> existingBorrows = borrowRepository.findByBookIdAndReturnDateIsNull(bookId);
        if (!existingBorrows.isEmpty()) {
            Borrow borrow = existingBorrows.get(0);
            borrow.setReturnDate(LocalDate.now());
            Borrow savedBorrow = borrowRepository.save(borrow);

            BookModel book = bookRepository.findById(bookId).orElseThrow();
            book.setAvailable(true);
            bookRepository.save(book);

            return savedBorrow;
        } else {
            throw new IllegalStateException("Book was not borrowed");
        }
    }
}
