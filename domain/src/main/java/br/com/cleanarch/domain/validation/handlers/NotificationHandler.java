package br.com.cleanarch.domain.validation.handlers;

import br.com.cleanarch.domain.exceptions.DomainException;
import br.com.cleanarch.domain.validation.Error;
import br.com.cleanarch.domain.validation.ValidationHandler;

import java.util.ArrayList;
import java.util.List;

public class NotificationHandler implements ValidationHandler {

    List<Error> errors = new ArrayList<>();

    @Override
    public ValidationHandler append(Error error) {
        errors.add(error);
        return this;
    }

    @Override
    public void validate() {
        if(this.hasError()) {
            throw new DomainException("error(s) happened while validate order", errors);
        }
    }

    @Override
    public List<Error> getErrors() {
        return errors;
    }
}
