package br.com.ada.adabook.exceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException() {
        super("Book not found.");
    }
}
