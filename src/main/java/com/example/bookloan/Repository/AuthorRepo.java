package com.example.bookloan.Repository;

import com.example.bookloan.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author, Long> {
}
