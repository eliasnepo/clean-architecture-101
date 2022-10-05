package br.com.cleanarch.domain.exceptions;

import java.util.ArrayList;
import java.util.List;

public class DomainException extends RuntimeException {

    public DomainException(String message) {
        super(message);
    }
}
