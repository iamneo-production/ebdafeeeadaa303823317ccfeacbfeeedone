package com.examly.springapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.examly.springapp.exception.BookNotFoundException;
import com.examly.springapp.model.Book;
import com.examly.springapp.service.BookService;

@SpringBootTest
class SpringappApplicationTests {
    private BookService bookService;

    @Test
    @BeforeEach
    public void setUp() {
        bookService = new BookService();
        // Add some sample books to the list for testing
        bookService.createBook(new Book(1L, "Book 1", "Author 1"));
        bookService.createBook(new Book(2L, "Book 2", "Author 2"));
    }

    @Test
    public void testGetAllBooks() {
        List<Book> books = bookService.getAllBooks();
        assertEquals(2, books.size());
    }

    @Test
    public void testGetBookByIdExisting() {
        Long bookId = 1L;
        Book book = bookService.getBookById(bookId);
        assertEquals(bookId, book.getId());
    }

    @Test
    public void testGetBookByIdNonExisting() {
        Long bookId = 3L;
        assertThrows(BookNotFoundException.class, () -> {
            bookService.getBookById(bookId);
        });
    }

    @Test
    public void testCreateBook() {
        Book newBook = new Book(3L, "New Book", "New Author");
        Book createdBook = bookService.createBook(newBook);
        assertEquals(3, bookService.getAllBooks().size());
        assertEquals(newBook, createdBook);
    }

    @Test

    public void controllerfolder() {
        String directoryPath = "src/main/java/com/examly/springapp/controller"; // Replace with the path to your
                                                                                // directory
        File directory = new File(directoryPath);
        assertTrue(directory.exists() && directory.isDirectory());
    }

    @Test
    public void controllerfile() {
        String filePath = "src/main/java/com/examly/springapp/controller/BookController.java";
        File file = new File(filePath);
        assertTrue(file.exists() && file.isFile());
    }

    @Test
    public void testModelFolder() {
        String directoryPath = "src/main/java/com/examly/springapp/model"; // Replace with the path to your directory
        File directory = new File(directoryPath);
        assertTrue(directory.exists() && directory.isDirectory());
    }

    @Test
    public void testModelFile() {
        String filePath = "src/main/java/com/examly/springapp/model/Book.java";
        File file = new File(filePath);
        assertTrue(file.exists() && file.isFile());
    }

    @Test
    public void testServiceFolder() {
        String directoryPath = "src/main/java/com/examly/springapp/service";
        File directory = new File(directoryPath);

        assertTrue(directory.exists() && directory.isDirectory());

    }

    @Test

    public void testServieFile() {

        String filePath = "src/main/java/com/examly/springapp/service/BookService.java";

        // Replace with the path to your file

        File file = new File(filePath);

        assertTrue(file.exists() && file.isFile());

    }

}
