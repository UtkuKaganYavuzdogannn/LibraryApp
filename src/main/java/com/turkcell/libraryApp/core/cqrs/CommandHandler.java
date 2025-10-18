package com.turkcell.libraryApp.core.cqrs;

public interface CommandHandler <C extends Command<R>, R>{
    R handle(C command);
}
