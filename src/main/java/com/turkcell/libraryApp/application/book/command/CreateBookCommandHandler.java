package com.turkcell.libraryApp.application.book.command;

import com.turkcell.libraryApp.application.book.dto.CreatedBookResponse;
import com.turkcell.libraryApp.application.book.mapper.CreateBookMapper;
import com.turkcell.libraryApp.core.cqrs.CommandHandler;
import com.turkcell.libraryApp.domain.book.model.Book;
import com.turkcell.libraryApp.domain.book.repository.BookRepository;
import org.springframework.stereotype.Component;

@Component
public class CreateBookCommandHandler implements CommandHandler<CreateBookCommand, CreatedBookResponse> {

    private final BookRepository bookRepository;
    private final CreateBookMapper createBookMapper;

    public CreateBookCommandHandler(BookRepository bookRepository, CreateBookMapper createBookMapper) {
        this.bookRepository = bookRepository;
        this.createBookMapper = createBookMapper;
    }

    @Override
    public CreatedBookResponse handle(CreateBookCommand command) {
        Book book = createBookMapper.toDomain(command);
        book = bookRepository.save(book);
        return createBookMapper.toResponse(book);
    }
}
