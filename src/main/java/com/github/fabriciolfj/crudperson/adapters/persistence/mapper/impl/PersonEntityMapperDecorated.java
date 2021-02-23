package com.github.fabriciolfj.crudperson.adapters.persistence.mapper.impl;

import com.github.fabriciolfj.crudperson.adapters.persistence.entity.PersonEntity;
import com.github.fabriciolfj.crudperson.adapters.persistence.mapper.PersonEntityMapper;
import com.github.fabriciolfj.crudperson.core.personcrud.domain.Person;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class PersonEntityMapperDecorated implements PersonEntityMapper {

    @Override
    public PersonEntity toEntity(Person person) {
        return PersonEntity.builder()
                .document(person.getDocument())
                .type(person.getType())
                .name(person.getName())
                .build();
    }
}
