package com.turkcell.libraryApp.domain.book.repository;

import com.turkcell.libraryApp.domain.book.model.Book;
import com.turkcell.libraryApp.domain.book.model.BookId;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface BookRepository {
    Book save(Book book);
    Optional<Book> findById(BookId bookId);
    List<Book> findAll();
    List<Book> findAllPaged(Integer pageIndex, Integer pageSize);
    void delete(BookId bookId);
}
