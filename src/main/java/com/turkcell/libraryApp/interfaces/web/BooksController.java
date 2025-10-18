package com.turkcell.libraryApp.interfaces.web;

import com.turkcell.libraryApp.application.book.command.CreateBookCommand;
import com.turkcell.libraryApp.application.book.dto.CreatedBookResponse;
import com.turkcell.libraryApp.core.cqrs.CommandHandler;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/books")
@Validated
public class BooksController {
    private final CommandHandler<CreateBookCommand, CreatedBookResponse> createBookCommandHandler;

    public BooksController(CommandHandler<CreateBookCommand, CreatedBookResponse> createBookCommandHandler) {
        this.createBookCommandHandler = createBookCommandHandler;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedBookResponse createBook(@Valid @RequestBody CreateBookCommand command){
        return createBookCommandHandler.handle(command);
    }
}
