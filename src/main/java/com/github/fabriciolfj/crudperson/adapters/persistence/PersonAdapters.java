package com.github.fabriciolfj.crudperson.adapters.persistence;

import com.github.fabriciolfj.crudperson.adapters.persistence.mapper.PersonEntityMapper;
import com.github.fabriciolfj.crudperson.adapters.persistence.repository.PersonRepository;
import com.github.fabriciolfj.crudperson.application.exception.PersonNotFoundException;
import com.github.fabriciolfj.crudperson.core.personcrud.domain.Person;
import com.github.fabriciolfj.crudperson.core.ports.out.PersonCrudOut;
import com.github.fabriciolfj.crudperson.core.ports.out.dto.PersonEntityResponse;
import com.github.fabriciolfj.crudperson.core.ports.out.mappers.PersonEntityResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PersonAdapters implements PersonCrudOut {

    private final PersonEntityMapper mapper;
    private final PersonEntityResponseMapper mapperResponse;
    private final PersonRepository repository;
    private static final String MSG = "Person not found. Id: ";

    @Override
    public void save(Person person) {
        repository.save(mapper.toEntity(person));
    }

    @Override
    public List<PersonEntityResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(mapperResponse::toResponseEntity)
                .collect(Collectors.toList());
    }

    @Override
    public PersonEntityResponse findById(Long id) {
        return repository.findById(id)
                .map(mapperResponse::toResponseEntity)
                .orElseThrow(() -> new PersonNotFoundException(MSG + id));
    }

    @Override
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {

        }
    }

    @Override
    public void update(Long id, Person person) {
        repository.findById(id)
                .map(entity -> {
                    BeanUtils.copyProperties(person, entity, "id");
                    return repository.save(entity);
                }).orElseThrow(() -> new PersonNotFoundException(MSG + id));
    }
}
