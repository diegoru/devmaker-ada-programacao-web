package br.com.ada.adabook.exceptions;

public class AuthorHasBookException extends RuntimeException {
    public AuthorHasBookException() {
        super("Author has books registered!");
    }
}
