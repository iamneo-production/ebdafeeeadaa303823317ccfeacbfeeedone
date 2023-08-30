package com.examly.springapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.examly.springapp.exception.BookNotFoundException;
import com.examly.springapp.model.Book;

@Service
public class BookService {
    private final List<Book> books = new ArrayList<>();

    public List<Book> getAllBooks() {
        return books;

        //return ResponseEntity.status(HttpStatus.CREATED).body("Successfully added the product to the cart");
    }

    public Book getBookById(Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));
    }

    public Book createBook(Book book) {
        
       books.add(book);
      
        return book;
        
    }

    // public Book updateBook(Long id, Book updatedBook) {
    //     Book book = getBookById(id);
    //     book.setTitle(updatedBook.getTitle());
    //     book.setAuthor(updatedBook.getAuthor());
    //     return book;
    // }

    // public void deleteBook(Long id) {
    //     books.removeIf(book -> book.getId().equals(id));
    // }
}
