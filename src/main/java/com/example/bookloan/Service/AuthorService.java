package com.example.bookloan.Service;

import com.example.bookloan.Models.Author;
import com.example.bookloan.Repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepo authorRepo;

    public List<Author> getAllAuthors() {
        return authorRepo.findAll();
    }

    public Author getAuthorById(Long id) {
        return authorRepo.findById(id).orElse(null);
    }

    public Author addAuthor(Author author) {
        return authorRepo.save(author);
    }

    public Author updateAuthor(Long id, Author updatedAuthor) {
        return authorRepo.findById(id).map(author -> {
            author.setName(updatedAuthor.getName());
            return authorRepo.save(author);
        }).orElse(null);
    }

    public void deleteAuthor(Long id) {
        authorRepo.deleteById(id);
    }

}
