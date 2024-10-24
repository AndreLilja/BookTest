package com.example.bookloan.Service;

import com.example.bookloan.Models.Book;
import com.example.bookloan.Repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepo.findById(id).orElse(null);
    }

    public Book addBook(Book book) {
        return bookRepo.save(book);
    }

    public Book updateBook(Long id, Book updatedBook) {
        return bookRepo.findById(id).map(book -> {
            book.setTitle(updatedBook.getTitle());
            book.setIsbn(updatedBook.getIsbn());
            book.setIsAvaliable(updatedBook.isIsAvaliable());
            book.setAuthor(updatedBook.getAuthor());
            return bookRepo.save(book);
        }).orElse(null);
    }

    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }

}
