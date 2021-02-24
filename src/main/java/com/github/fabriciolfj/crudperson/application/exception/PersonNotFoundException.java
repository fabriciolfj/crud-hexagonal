package com.github.fabriciolfj.crudperson.application.exception;

public class PersonNotFoundException extends RuntimeException {

    public PersonNotFoundException(final String msg) {
        super(msg);
    }
}
