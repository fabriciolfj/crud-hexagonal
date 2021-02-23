package com.github.fabriciolfj.crudperson.core.ports.out;

import com.github.fabriciolfj.crudperson.core.personcrud.domain.Person;
import com.github.fabriciolfj.crudperson.core.ports.out.dto.PersonEntityResponse;

import java.util.List;

public interface PersonCrudOut {

    void save(Person person);
    List<PersonEntityResponse> findAll();
    PersonEntityResponse findById(final Long id);
    void delete(final Long id);
    void update(final Long id, final Person person);
}
