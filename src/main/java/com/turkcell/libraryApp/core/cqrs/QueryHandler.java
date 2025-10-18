package com.turkcell.libraryApp.core.cqrs;

public interface QueryHandler <Q extends Query<R>,R>{
    R handle(Q query);
}
