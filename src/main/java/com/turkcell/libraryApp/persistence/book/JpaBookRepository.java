package com.turkcell.libraryApp.persistence.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaBookRepository extends JpaRepository<JpaBookEntity, UUID> {
}
