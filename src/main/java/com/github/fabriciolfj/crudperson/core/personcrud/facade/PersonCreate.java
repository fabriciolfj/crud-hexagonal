package com.github.fabriciolfj.crudperson.core.personcrud.facade;

import com.github.fabriciolfj.crudperson.core.personcrud.domain.Person;
import com.github.fabriciolfj.crudperson.core.personcrud.domain.PersonLegal;
import com.github.fabriciolfj.crudperson.core.personcrud.domain.PersonPhysical;
import com.github.fabriciolfj.crudperson.core.ports.in.DocumentIn;
import com.github.fabriciolfj.crudperson.core.ports.in.dto.PersonRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static java.util.Optional.of;

@Component
@RequiredArgsConstructor
public class PersonCreate {

    private final DocumentIn documentIn;

    public Optional<Person> execute(PersonRequest personRequest) {
        return of(personRequest)
                .filter(r -> documentIn.isCnpj(r.getDocument()) || documentIn.isCpf(r.getDocument()))
                .map(request -> {
                    if (documentIn.isCpf(request.getDocument())) {
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
