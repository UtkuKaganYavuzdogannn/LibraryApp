package com.turkcell.libraryApp.application.publisher.mapper;

import com.turkcell.libraryApp.application.publisher.command.CreatePublisherCommand;
import com.turkcell.libraryApp.application.publisher.dto.CreatedPublisherResponse;
import com.turkcell.libraryApp.domain.publisher.model.Address;
import com.turkcell.libraryApp.domain.publisher.model.Name;
import com.turkcell.libraryApp.domain.publisher.model.Publisher;
import org.springframework.stereotype.Component;

@Component
public class CreatePublisherMapper{
    public Publisher toDomain(CreatePublisherCommand command){
        return Publisher.create(
                new Name(command.name()),
                new Address(command.address())
        );
    }
    public CreatedPublisherResponse toResponse(Publisher publisher){
        return new CreatedPublisherResponse(
                publisher.id().value(),
                publisher.name().value(),
                publisher.address().value()
        );
    }
}
