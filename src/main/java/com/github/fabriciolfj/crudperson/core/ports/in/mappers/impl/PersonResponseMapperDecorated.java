package com.github.fabriciolfj.crudperson.core.ports.in.mappers.impl;

import com.github.fabriciolfj.crudperson.core.ports.in.dto.PersonResponse;
import com.github.fabriciolfj.crudperson.core.ports.in.mappers.PersonResponseMapper;
import com.github.fabriciolfj.crudperson.core.personcrud.domain.Person;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class PersonResponseMapperDecorated implements PersonResponseMapper {

    @Override
    public PersonResponse toResponse(Person person) {
        return PersonResponse.builder()
                .document(person.getDocument())
                .type(person.getType())
                .name(person.getName())
                .build();
    }
}
