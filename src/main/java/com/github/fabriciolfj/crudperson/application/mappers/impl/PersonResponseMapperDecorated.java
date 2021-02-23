package com.github.fabriciolfj.crudperson.application.mappers.impl;

import com.github.fabriciolfj.crudperson.application.dto.PersonResponse;
import com.github.fabriciolfj.crudperson.application.mappers.PersonResponseMapper;
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
