package com.github.fabriciolfj.crudperson.adapters.persistence;

import com.github.fabriciolfj.crudperson.adapters.persistence.mapper.PersonEntityMapper;
import com.github.fabriciolfj.crudperson.adapters.persistence.repository.PersonRepository;
import com.github.fabriciolfj.crudperson.core.personcrud.domain.Person;
import com.github.fabriciolfj.crudperson.core.personcrud.dto.PersonRequest;
import com.github.fabriciolfj.crudperson.core.ports.out.PersonCrudOut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PersonAdapters implements PersonCrudOut {

    private final PersonEntityMapper mapper;
    private final PersonRepository repository;

    @Override
    public void save(Person person) {
        repository.save(mapper.toEntity(person));
    }

    @Override
    public List<PersonRequest> findAll() {
        return null;
    }

    @Override
    public PersonRequest findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Long id, Person person) {

    }
}
