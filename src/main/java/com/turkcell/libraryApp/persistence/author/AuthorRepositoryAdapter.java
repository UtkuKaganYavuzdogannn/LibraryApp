package com.turkcell.libraryApp.persistence.author;

import com.turkcell.libraryApp.domain.author.model.Author;
import com.turkcell.libraryApp.domain.author.model.AuthorId;
import com.turkcell.libraryApp.domain.author.repository.AuthorRepository;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public class AuthorRepositoryAdapter implements AuthorRepository {
    private final JpaAuthorRepository jpaAuthorRepository;
    private final AuthorEntityMapper authorEntityMapper;

    public AuthorRepositoryAdapter(JpaAuthorRepository jpaAuthorRepository, AuthorEntityMapper authorEntityMapper) {
        this.jpaAuthorRepository = jpaAuthorRepository;
        this.authorEntityMapper = authorEntityMapper;
    }

    @Override
    public Author save(Author author) {
        JpaAuthorEntity entity = authorEntityMapper.toEntity(author);
        entity = jpaAuthorRepository.save(entity);
        return authorEntityMapper.toDomain(entity);
    }

    @Override
    public Optional<Author> findById(AuthorId authorId) {
        return jpaAuthorRepository.findById(authorId.value()).map(authorEntityMapper::toDomain);
    }

    @Override
    public List<Author> findAll() {
        return jpaAuthorRepository.findAll()
                .stream()
                .map(authorEntityMapper::toDomain)
                .toList();
    }

    @Override
    public List<Author> findAllPaged(Integer pageIndex, Integer pageSize) {
        return jpaAuthorRepository.findAll(PageRequest.of(pageIndex, pageSize))
                .stream()
                .map(authorEntityMapper::toDomain)
                .toList();
    }

    @Override
    public void delete(AuthorId authorId) {
        jpaAuthorRepository.deleteById(authorId.value());
    }
}
