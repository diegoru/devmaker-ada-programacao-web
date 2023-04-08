package br.com.ada.adabook.exceptions;

public class PublisherNotFoundException extends RuntimeException {
    public PublisherNotFoundException() {
        super("Publisher not found.");
    }
}
