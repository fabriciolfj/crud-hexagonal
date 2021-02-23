package com.github.fabriciolfj.crudperson.core.ports.in;

import com.github.fabriciolfj.crudperson.core.ports.in.dto.PersonRequest;
import com.github.fabriciolfj.crudperson.core.ports.in.dto.PersonResponse;

import java.util.List;

public interface PersonCrudIn {

    PersonResponse save(final PersonRequest request);
    List<PersonResponse> findAll();
    PersonResponse findById(final Long id);
    void delete(final Long id);
    void update(final Long id, final PersonRequest request);
}
