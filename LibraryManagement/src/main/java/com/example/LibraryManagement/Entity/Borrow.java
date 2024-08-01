package com.example.LibraryManagement.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "borrows")
public class Borrow {
    @Id
    private String id;
    private String userId;
    private String bookId;
    private LocalDate borrowDate;
    private LocalDate returnDate;
}

