package com.github.fabriciolfj.crudperson.adapters.persistence.mapper.impl;

import com.github.fabriciolfj.crudperson.adapters.persistence.entity.PersonEntity;
import com.github.fabriciolfj.crudperson.adapters.persistence.mapper.PersonEntityMapper;
import com.github.fabriciolfj.crudperson.core.personcrud.domain.Person;
import com.github.fabriciolfj.crudperson.core.ports.in.dto.PersonResponse;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class PersonEntityMapperDecorated implements PersonEntityMapper {

    @Override
    public PersonEntity toEntity(final Person person) {
        return PersonEntity.builder()
                .document(person.getDocument())
                .type(person.getType())
                .name(person.getName())
                .build();
    }

    @Override
    public PersonResponse toRequest(final PersonEntity entity) {
        return PersonResponse
                .builder()
                .document(entity.getDocument())
                .name(entity.getName())
                .type(entity.getType())
                .build();
    }
}
