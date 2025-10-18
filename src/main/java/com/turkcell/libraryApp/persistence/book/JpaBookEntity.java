package com.turkcell.libraryApp.persistence.book;

import com.turkcell.libraryApp.domain.book.model.BookStatus;
import com.turkcell.libraryApp.persistence.author.JpaAuthorEntity;
import com.turkcell.libraryApp.persistence.publisher.JpaPublisherEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.UUID;

@Table(name="books")
@Entity
public class JpaBookEntity {
    @Id
    private UUID id;


    @Column(nullable = false)
    @Size(max = 150)
    private String title;

    @Column(nullable = false)
    private LocalDate year;

    @Column(nullable = false)

    @Size(max = 150)
    private String language;

    @Column(name = "total_copies", nullable = false)
    @Positive
    private int totalCopies;

    @Column(name = "isbn", unique = true, nullable = false)
    private String isbn;

    @Enumerated(EnumType.STRING)
    @Column(name = "book_status", nullable = false)
    private BookStatus bookStatus;

    @Column(nullable = false)
    @Positive
    private int availableCopies;

    @ManyToOne
    @JoinColumn(name="author_id", nullable = false)
    private JpaAuthorEntity author;

    @ManyToOne
    @JoinColumn(name="publisher_id", nullable = false)
    private JpaPublisherEntity publisher;

    public UUID id() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String title() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate year() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public String language() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int totalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }

    public String isbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public BookStatus bookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

    public int availableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public JpaAuthorEntity author() {
        return author;
    }

    public void setAuthor(JpaAuthorEntity author) {
        this.author = author;
    }

    public JpaPublisherEntity publisher() {
        return publisher;
    }

    public void setPublisher(JpaPublisherEntity publisher) {
        this.publisher = publisher;
    }

}
