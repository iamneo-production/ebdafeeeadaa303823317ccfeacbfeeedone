package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.exception.BookNotFoundException;
import com.examly.springapp.model.Book;
import com.examly.springapp.service.BookService;

@RestController
public class BookController {
    @Autowired
    private final BookService bookService;



    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public @ResponseBody ResponseEntity<Book> getBookById(@PathVariable Long id) {

        return ResponseEntity.ok(bookService.getBookById(id));


        // try {
        //     Book book = bookService.getBookById(id);
        //     return ResponseEntity.ok(book); // Status 200 OK and response body: Book details
        // } catch (BookNotFoundException ex) {
        //     return ResponseEntity.notFound().body(new BookNotFoundException("Book not found with id: " + id)); // Status 404 Not Found
        // }
    }


    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleEmployeeNotFound(
            BookNotFoundException exception
    ) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }
   
    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book createdBook = bookService.createBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

    // @PutMapping("/books/{id}")
    // public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
    //     return bookService.updateBook(id, updatedBook);
    // }

    // @DeleteMapping("/books/{id}")
    // public ResponseEntity<String> deleteBook(@PathVariable Long id) {
    //     bookService.deleteBook(id);
    //     return ResponseEntity.ok("Book with id " + id + " deleted successfully.");
    // }
}
