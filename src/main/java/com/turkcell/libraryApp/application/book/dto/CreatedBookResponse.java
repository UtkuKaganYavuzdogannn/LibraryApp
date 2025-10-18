package com.turkcell.libraryApp.application.book.dto;

import com.turkcell.libraryApp.domain.author.model.AuthorId;
import com.turkcell.libraryApp.domain.publisher.model.PublisherId;

import java.time.LocalDate;
import java.util.UUID;

public record CreatedBookResponse(UUID bookId,
                                  String title,
                                  String language,
                                  BookStatusDto bookStatus,
                                  LocalDate year,
                                  Integer totalCopies,
                                  Integer availableCopies,
                                  String isbn,
                                  AuthorId authorId,
                                  PublisherId publisherId) { }
