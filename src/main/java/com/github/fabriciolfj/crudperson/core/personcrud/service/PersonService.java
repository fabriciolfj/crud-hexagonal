package com.github.fabriciolfj.crudperson.core.personcrud.service;

import com.github.fabriciolfj.crudperson.core.personcrud.domain.Person;
import com.github.fabriciolfj.crudperson.core.personcrud.domain.PersonLegal;
import com.github.fabriciolfj.crudperson.core.personcrud.domain.PersonPhysical;
import com.github.fabriciolfj.crudperson.core.ports.in.dto.PersonRequest;
import com.github.fabriciolfj.crudperson.core.ports.out.dto.PersonResponse;
import com.github.fabriciolfj.crudperson.core.ports.out.mappers.PersonResponseMapper;
import com.github.fabriciolfj.crudperson.core.ports.in.DocumentIn;
import com.github.fabriciolfj.crudperson.core.ports.in.PersonCrudIn;
import com.github.fabriciolfj.crudperson.core.ports.out.PersonCrudOut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.of;

@Service
@RequiredArgsConstructor
public class PersonService implements PersonCrudIn {

    private final DocumentIn documentValidate;
    private final PersonCrudOut personCrudOut;
    private final PersonResponseMapper personResponseMapper;

    @Override
    public PersonResponse save(final PersonRequest personRequest) {
        return getPerson(personRequest)
                .map(p -> {
                    personCrudOut.save(p);
                    return personResponseMapper.toResponse(p);
                })
                .orElseThrow(() -> new RuntimeException("Document invalid: " + personRequest.getDocument()));
    }

    @Override
    public List<PersonResponse> findAll() {
        return personCrudOut.findAll();
    }

    @Override
    public PersonResponse findById(final Long id) {
        return personCrudOut.findById(id);
    }

    @Override
    public void delete(final Long id) {
        personCrudOut.delete(id);
    }

    @Override
    public void update(final Long id, final PersonRequest request) {
        getPerson(request)
                .map(p -> {
                    personCrudOut.update(id, p);
                    return p;
                })
                .orElseThrow(() -> new RuntimeException("Document invalid"));
    }

    private Optional<Person> getPerson(PersonRequest personRequest) {
        return of(personRequest)
                .filter(r -> documentValidate.isCnpj(r.getDocument()) || documentValidate.isCpf(r.getDocument()))
                .map(request -> {
                    if (documentValidate.isCpf(request.getDocument())) {
                        return PersonPhysical
                                .builder()
                                .name(request.getName())
                                .document(request.getDocument())
                                .build();
                    }
                    return PersonLegal
                            .builder()
                            .document(request.getDocument())
                            .name(request.getName())
                            .build();

                });
    }
}
