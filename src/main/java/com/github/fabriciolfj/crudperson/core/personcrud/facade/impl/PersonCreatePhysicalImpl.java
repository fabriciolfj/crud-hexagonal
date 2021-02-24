package com.github.fabriciolfj.crudperson.core.personcrud.facade.impl;

import com.github.fabriciolfj.crudperson.core.personcrud.domain.Person;
import com.github.fabriciolfj.crudperson.core.personcrud.domain.PersonPhysical;
import com.github.fabriciolfj.crudperson.core.personcrud.facade.PersonCreate;
import com.github.fabriciolfj.crudperson.core.ports.in.DocumentIn;
import com.github.fabriciolfj.crudperson.core.ports.in.dto.PersonRequest;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PersonCreatePhysicalImpl implements PersonCreate {

    @Override
    public Optional<Person> execute(final PersonRequest personRequest) {
        return Optional.of(PersonPhysical
            .builder()
            .name(personRequest.getName())
            .document(personRequest.getDocument())
            .build());
    }

    @Override
    public boolean isValid(final DocumentIn documentIn, final String document) {
        return documentIn.isCpf(document);
    }
}
