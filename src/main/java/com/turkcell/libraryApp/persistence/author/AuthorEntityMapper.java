package com.turkcell.libraryApp.persistence.author;

import com.turkcell.libraryApp.domain.author.model.Author;
import com.turkcell.libraryApp.domain.author.model.AuthorId;
import com.turkcell.libraryApp.domain.author.model.Name;
import com.turkcell.libraryApp.domain.author.model.Surname;
import org.springframework.stereotype.Component;

@Component
public class AuthorEntityMapper {
    public JpaAuthorEntity toEntity(Author author){
        JpaAuthorEntity jpaAuthorEntity = new JpaAuthorEntity();
        jpaAuthorEntity.setId(author.id().value());
        jpaAuthorEntity.setName(author.name().value());
        jpaAuthorEntity.setSurName(author.surname().value());
        return jpaAuthorEntity;
    }
    public Author toDomain(JpaAuthorEntity entity){
        return Author.rehydrate(
                new AuthorId(entity.id()),
                new Name(entity.name()),
                new Surname(entity.surName())
        );
    }
}
