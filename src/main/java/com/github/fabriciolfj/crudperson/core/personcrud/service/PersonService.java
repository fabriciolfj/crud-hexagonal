package com.github.fabriciolfj.crudperson.core.personcrud.service;

import com.github.fabriciolfj.crudperson.core.personcrud.facade.PersonCreate;
import com.github.fabriciolfj.crudperson.core.ports.in.dto.PersonRequest;
import com.github.fabriciolfj.crudperson.core.ports.in.dto.PersonResponse;
import com.github.fabriciolfj.crudperson.core.ports.in.mappers.PersonResponseMapper;
import com.github.fabriciolfj.crudperson.core.ports.in.PersonCrudIn;
import com.github.fabriciolfj.crudperson.core.ports.out.PersonCrudOut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonService implements PersonCrudIn {

    private final PersonCreate personCreate;
    private final PersonCrudOut personCrudOut;
    private final PersonResponseMapper personResponseMapper;

    @Override
    public PersonResponse save(final PersonRequest personRequest) {
        return personCreate.execute(personRequest)
                .map(p -> {
                    personCrudOut.save(p);
                    return personResponseMapper.toResponse(p);
                })
                .orElseThrow(() -> new RuntimeException("Document invalid: " + personRequest.getDocument()));
    }

    @Override
    public List<PersonResponse> findAll() {
        return personCrudOut.findAll()
                .stream()
                .map(personResponseMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PersonResponse findById(final Long id) {
        final var person = personCrudOut.findById(id);
        return personResponseMapper.toResponse(person);
    }

    @Override
    public void delete(final Long id) {
        personCrudOut.delete(id);
    }

    @Override
    public void update(final Long id, final PersonRequest request) {
        personCreate.execute(request)
                .map(p -> {
                    personCrudOut.update(id, p);
                    return p;
                })
                .orElseThrow(() -> new RuntimeException("Document invalid"));
    }
}
