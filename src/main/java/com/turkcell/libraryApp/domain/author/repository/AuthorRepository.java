package com.turkcell.libraryApp.domain.author.repository;

import com.turkcell.libraryApp.domain.author.model.Author;
import com.turkcell.libraryApp.domain.author.model.AuthorId;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {
    Author save(Author author);
    Optional<Author> findById(AuthorId authorId);
    List<Author> findAll();
    List<Author> findAllPaged(Integer pageIndex, Integer pageSize);
    void delete(AuthorId authorId);
}
