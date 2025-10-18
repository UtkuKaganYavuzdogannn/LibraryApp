package com.turkcell.libraryApp.application.book.mapper;

import com.turkcell.libraryApp.application.book.command.CreateBookCommand;
import com.turkcell.libraryApp.application.book.dto.BookStatusDto;
import com.turkcell.libraryApp.application.book.dto.CreatedBookResponse;
import com.turkcell.libraryApp.domain.author.model.AuthorId;
import com.turkcell.libraryApp.domain.book.model.*;
import com.turkcell.libraryApp.domain.publisher.model.PublisherId;
import org.springframework.stereotype.Component;

@Component
public class CreateBookMapper {
    public Book toDomain(CreateBookCommand command){
        BookStatus status = BookStatus.valueOf(command.bookStatus().name());
        return Book.create(
                new Title(command.title()),
                new Language(command.language()),
                status,
                new Year(command.year()),
                new TotalCopies(command.totalCopies()),
                new AvailableCopies(command.availableCopies()),
                new Isbn(command.isbn()),
                new AuthorId(command.authorId().value()),
                new PublisherId(command.publisherId().value())
        );
    }
    public CreatedBookResponse toResponse(Book book){
        var statusDto = BookStatusDto.valueOf(book.bookStatus().name());
        return new CreatedBookResponse(
                book.bookId().value(),
                book.title().value(),
                book.language().value(),
                statusDto,
                book.year().value(),
                book.totalCopies().copy(),
                book.availableCopies().copy(),
                book.isbn().value(),
                book.authorId(),
                book.publisherId()
        );
    }
}
