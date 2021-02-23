package com.github.fabriciolfj.crudperson.core.personcrud.service;

import com.github.fabriciolfj.crudperson.core.personcrud.domain.Person;
import com.github.fabriciolfj.crudperson.core.personcrud.domain.PersonLegal;
import com.github.fabriciolfj.crudperson.core.personcrud.domain.PersonPhysical;
import com.github.fabriciolfj.crudperson.core.personcrud.dto.PersonRequest;
import com.github.fabriciolfj.crudperson.core.ports.in.DocumentValidate;
import com.github.fabriciolfj.crudperson.core.ports.in.PersonCrudIn;
import com.github.fabriciolfj.crudperson.core.ports.out.PersonCrudOut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

import static java.util.Optional.of;

@Service
@RequiredArgsConstructor
public class PersonService implements PersonCrudIn {

    private final DocumentValidate documentValidate;
    private final PersonCrudOut personCrudOut;

    @Override
    public Person save(final PersonRequest personRequest) {
        return of(personRequest)
                .filter(r -> documentValidate.isCnpj(r.getDocument()) || documentValidate.isCpf(r.getDocument()))
                .map(request -> {
                   if (documentValidate.isCnpj(request.getDocument())) {
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

                })
                .map(p -> {
                    personCrudOut.save(p);
                    return p;
                })
                .orElseThrow(() -> new RuntimeException("Document invalid: " + personRequest.getDocument()));
    }

    @Override
    public List<Person> findAll() {
        return null;
    }

    @Override
    public Person findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Long id, PersonRequest request) {

    }
}
