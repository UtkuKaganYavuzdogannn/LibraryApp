package com.turkcell.libraryApp.persistence.book;

import com.turkcell.libraryApp.domain.author.model.AuthorId;
import com.turkcell.libraryApp.domain.book.model.*;
import com.turkcell.libraryApp.domain.publisher.model.PublisherId;
import com.turkcell.libraryApp.persistence.author.JpaAuthorEntity;
import com.turkcell.libraryApp.persistence.publisher.JpaPublisherEntity;
import org.springframework.stereotype.Component;

@Component
public class BookEntityMapper {
    public JpaBookEntity toEntity(Book book){
        JpaBookEntity jpaBookEntity = new JpaBookEntity();
        jpaBookEntity.setId(book.bookId().value());
        jpaBookEntity.setTitle(book.title().value());
        jpaBookEntity.setLanguage(book.language().value());
        jpaBookEntity.setTotalCopies(book.totalCopies().copy());
        jpaBookEntity.setAvailableCopies(book.availableCopies().copy());
        jpaBookEntity.setYear(book.year().value());
        jpaBookEntity.setIsbn(book.isbn().value());
        jpaBookEntity.setBookStatus(book.bookStatus());

        JpaAuthorEntity authorRef = new JpaAuthorEntity();
        authorRef.setId(book.authorId().value());
        jpaBookEntity.setAuthor(authorRef);

        JpaPublisherEntity publisherRef = new JpaPublisherEntity();
        publisherRef.setId(book.publisherId().value());
        jpaBookEntity.setPublisher(publisherRef);


        return jpaBookEntity;
    }
    public Book toDomain(JpaBookEntity jpaBookEntity){
        AuthorId authorId = new AuthorId(jpaBookEntity.author().id());
        PublisherId publisherId = new PublisherId(jpaBookEntity.publisher().id());

        return Book.rehydrate(
                new BookId(jpaBookEntity.id()),
                new Title(jpaBookEntity.title()),
                new Language(jpaBookEntity.language()),
                jpaBookEntity.bookStatus(),
                new Year(jpaBookEntity.year()),
                new TotalCopies(jpaBookEntity.totalCopies()),
                new AvailableCopies(jpaBookEntity.availableCopies()),
                new Isbn(jpaBookEntity.isbn()),
                authorId,
                publisherId
        );
    }
}
