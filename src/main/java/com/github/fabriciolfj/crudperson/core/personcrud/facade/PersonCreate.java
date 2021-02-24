package com.github.fabriciolfj.crudperson.core.personcrud.facade;

import com.github.fabriciolfj.crudperson.core.personcrud.domain.Person;
import com.github.fabriciolfj.crudperson.core.ports.in.DocumentIn;
import com.github.fabriciolfj.crudperson.core.ports.in.dto.PersonRequest;

import java.util.Optional;

public interface PersonCreate {

    Optional<Person> execute(final PersonRequest personRequest);
    boolean isValid(final DocumentIn documentIn, final String document);

}
