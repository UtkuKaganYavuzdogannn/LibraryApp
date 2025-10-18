package com.turkcell.libraryApp.domain.book.model;

import java.math.BigDecimal;
import java.util.Objects;

public record TotalCopies(Integer copy) {
    public TotalCopies{
        Objects.requireNonNull(copy, "Total copy null olamaz");
        if(copy < 0)
            throw new IllegalArgumentException("Total copies negatif olamaz");

    }
}
