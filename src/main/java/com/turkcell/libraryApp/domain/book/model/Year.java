package com.turkcell.libraryApp.domain.book.model;

import java.time.LocalDate;

public record Year(LocalDate value) {
    public Year{
        if(value == null)
            throw new IllegalArgumentException("Tarih null olamaz");

        if (value.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Year cannot be in the future");
        }
    }
}
