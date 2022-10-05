package br.com.cleanarch.domain.exceptions;

import br.com.cleanarch.domain.validation.Error;

import java.util.ArrayList;
import java.util.List;

public class DomainException extends RuntimeException {

    List<Error> erros = new ArrayList<>();

    public DomainException(String message) {
        super(message);
    }

    public DomainException(String message, List<Error> errors) {
        super(message);
        this.erros.addAll(errors);
    }
}
