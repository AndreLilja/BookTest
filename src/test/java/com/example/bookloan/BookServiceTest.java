package com.example.bookloan;

import com.example.bookloan.Models.Author;
import com.example.bookloan.Models.Book;
import com.example.bookloan.Repository.BookRepo;
import com.example.bookloan.Service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    @Mock
    private BookRepo bookRepo;

    @InjectMocks
    private BookService bookService;

    private Author author;
    private Book book;

    @BeforeEach
    void setUp() {
        author = new Author(1L, "Author Name", null);

        // Create a Book instance and associate it with the Author
        book = new Book(1L, "Book Title", "123456789", true, author);

        // Also ensure the Author's book list is correctly populated
        author.setBooks(new HashSet<>(Arrays.asList(book)));

    }

    @Test
    void testGetAllBooks() {
        when(bookRepo.findAll()).thenReturn(Arrays.asList(book));

        // Act
        var books = bookService.getAllBooks();

        // Assert
        assertNotNull(books);
        assertEquals(1, books.size());
        assertEquals(book.getTitle(), books.get(0).getTitle());
    }

    @Test
    public void testGetBookById() {
        // Arrange
        when(bookRepo.findById(1L)).thenReturn(Optional.of(book));

        // Act
        var foundBook = bookService.getBookById(1L);

        // Assert
        assertNotNull(foundBook);
        assertEquals(book.getId(), foundBook.getId());
        assertEquals(book.getTitle(), foundBook.getTitle());
    }

    @Test
    public void testGetBookByIdNotFound() {
        // Arrange
        when(bookRepo.findById(1L)).thenReturn(Optional.empty());

        // Act
        var foundBook = bookService.getBookById(1L);

        // Assert
        assertNull(foundBook);
    }

    @Test
    public void testAddBook() {
        // Arrange
        when(bookRepo.save(any(Book.class))).thenReturn(book);

        // Act
        var savedBook = bookService.addBook(book);

        // Assert
        assertNotNull(savedBook);
        assertEquals(book.getTitle(), savedBook.getTitle());
        verify(bookRepo, times(1)).save(book);
    }

    @Test
    public void testDeleteBook() {
        // Arrange
        doNothing().when(bookRepo).deleteById(1L);

        // Act
        bookService.deleteBook(1L);

        // Assert
        verify(bookRepo, times(1)).deleteById(1L);
    }
}
