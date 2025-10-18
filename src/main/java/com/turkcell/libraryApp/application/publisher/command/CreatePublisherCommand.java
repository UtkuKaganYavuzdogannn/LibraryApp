package com.turkcell.libraryApp.application.publisher.command;

import com.turkcell.libraryApp.application.publisher.dto.CreatedPublisherResponse;
import com.turkcell.libraryApp.core.cqrs.Command;
import jakarta.validation.constraints.NotBlank;

public record CreatePublisherCommand(@NotBlank String name, @NotBlank String address) implements Command<CreatedPublisherResponse> {
}
