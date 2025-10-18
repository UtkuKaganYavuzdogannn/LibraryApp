package com.turkcell.libraryApp.persistence.publisher;

import com.turkcell.libraryApp.domain.publisher.model.Address;
import com.turkcell.libraryApp.domain.publisher.model.Name;
import com.turkcell.libraryApp.domain.publisher.model.Publisher;
import com.turkcell.libraryApp.domain.publisher.model.PublisherId;
import org.springframework.stereotype.Component;

@Component
public class PublisherEntityMapper{
    public JpaPublisherEntity toEntity(Publisher publisher){
        JpaPublisherEntity jpaPublisherEntity = new JpaPublisherEntity();
        jpaPublisherEntity.setId(publisher.id().value());
        jpaPublisherEntity.setName(publisher.name().value());
        jpaPublisherEntity.setAddress(publisher.address().value());
        return jpaPublisherEntity;
    }
    public Publisher toDomain(JpaPublisherEntity jpaPublisherEntity){
        return Publisher.rehdyrate(
                new PublisherId(jpaPublisherEntity.id()),
                new Name(jpaPublisherEntity.name()),
                new Address(jpaPublisherEntity.address())
        );
    }
}
