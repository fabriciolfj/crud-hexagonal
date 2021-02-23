package com.github.fabriciolfj.crudperson.core.ports.in;

import com.github.fabriciolfj.crudperson.core.personcrud.dto.PersonRequest;
import com.github.fabriciolfj.crudperson.core.personcrud.domain.Person;

import java.util.List;

public interface PersonCrudIn {

    Person save(final PersonRequest request);
    List<Person> findAll();
    Person findById(final Long id);
    void delete(final Long id);
    void update(final Long id, final PersonRequest request);
}
