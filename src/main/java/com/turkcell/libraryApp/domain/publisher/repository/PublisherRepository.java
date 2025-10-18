package com.turkcell.libraryApp.domain.publisher.repository;
import com.turkcell.libraryApp.domain.publisher.model.Publisher;
import com.turkcell.libraryApp.domain.publisher.model.PublisherId;

import java.util.List;
import java.util.Optional;

public interface PublisherRepository {
    Publisher save(Publisher publisher);
    Optional<Publisher> findById(PublisherId publisherId);
    List<Publisher> findAll();
    List<Publisher> findAllPaged(Integer pageIndex, Integer pageSize);
    void delete(PublisherId publisherId);
}
