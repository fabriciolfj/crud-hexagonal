package com.github.fabriciolfj.crudperson.core.personcrud.facade.impl;

import com.github.fabriciolfj.crudperson.core.personcrud.domain.Person;
import com.github.fabriciolfj.crudperson.core.personcrud.domain.PersonLegal;
import com.github.fabriciolfj.crudperson.core.personcrud.facade.PersonCreate;
import com.github.fabriciolfj.crudperson.core.ports.in.DocumentIn;
import com.github.fabriciolfj.crudperson.core.ports.in.dto.PersonRequest;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PersonCreateLegalImpl implements PersonCreate {

    @Override
    public Optional<Person> execute(final PersonRequest personRequest) {
        return Optional.of(PersonLegal
                .builder()
                .name(personRequest.getName())
                .document(personRequest.getDocument())
                .build());
    }

    @Override
    public boolean isValid(final DocumentIn documentIn, final String document) {
        return documentIn.isCnpj(document);
    }
}
