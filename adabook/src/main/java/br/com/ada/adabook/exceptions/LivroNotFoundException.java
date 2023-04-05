package br.com.ada.adabook.exceptions;

public class LivroNotFoundException extends RuntimeException {
    public LivroNotFoundException() {
        super("Livro não encontrado");
    }
}
