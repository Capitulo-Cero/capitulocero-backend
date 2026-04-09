package com.factoriaf5.library.repository;

import com.factoriaf5.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
