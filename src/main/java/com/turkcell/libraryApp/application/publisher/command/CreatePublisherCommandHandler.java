package com.turkcell.libraryApp.application.publisher.command;

import com.turkcell.libraryApp.application.publisher.dto.CreatedPublisherResponse;
import com.turkcell.libraryApp.application.publisher.mapper.CreatePublisherMapper;
import com.turkcell.libraryApp.core.cqrs.CommandHandler;
import com.turkcell.libraryApp.domain.publisher.model.Publisher;
import com.turkcell.libraryApp.domain.publisher.repository.PublisherRepository;
import org.springframework.stereotype.Component;

@Component
public class CreatePublisherCommandHandler implements CommandHandler<CreatePublisherCommand, CreatedPublisherResponse> {

    private final PublisherRepository publisherRepository;
    private final CreatePublisherMapper createPublisherMapper;

    public CreatePublisherCommandHandler(PublisherRepository publisherRepository, CreatePublisherMapper createPublisherMapper) {
        this.publisherRepository = publisherRepository;
        this.createPublisherMapper = createPublisherMapper;
    }

    @Override
    public CreatedPublisherResponse handle(CreatePublisherCommand command) {
        Publisher publisher = createPublisherMapper.toDomain(command);
        publisher = publisherRepository.save(publisher);
        return createPublisherMapper.toResponse(publisher);
    }
}
