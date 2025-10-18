package com.turkcell.libraryApp.application.book.command;

import com.turkcell.libraryApp.application.book.dto.BookStatusDto;
import com.turkcell.libraryApp.application.book.dto.CreatedBookResponse;
import com.turkcell.libraryApp.core.cqrs.Command;
import com.turkcell.libraryApp.domain.author.model.AuthorId;
import com.turkcell.libraryApp.domain.publisher.model.PublisherId;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateBookCommand(
                                @NotBlank String title,
                                @NotBlank String language,
                                @NotNull BookStatusDto bookStatus,
                                @NotNull LocalDate year,
                                @NotNull Integer totalCopies,
                                @NotNull Integer availableCopies,
                                @NotBlank String isbn,
                                @NotNull AuthorId authorId,
                                @NotNull PublisherId publisherId)implements Command<CreatedBookResponse> {
}
