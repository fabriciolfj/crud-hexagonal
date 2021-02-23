package com.github.fabriciolfj.crudperson.application.api;

import com.github.fabriciolfj.crudperson.application.dto.PersonResponse;
import com.github.fabriciolfj.crudperson.application.mappers.PersonResponseMapper;
import com.github.fabriciolfj.crudperson.core.personcrud.domain.Person;
import com.github.fabriciolfj.crudperson.core.personcrud.dto.PersonRequest;
import com.github.fabriciolfj.crudperson.core.ports.in.PersonCrudIn;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonCrudIn personCrudIn;
    private final PersonResponseMapper mapper;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public PersonResponse save(@RequestBody final PersonRequest request) {
        final Person person = personCrudIn.save(request);
        return mapper.toResponse(person);
    }
}
