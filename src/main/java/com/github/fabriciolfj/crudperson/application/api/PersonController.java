package com.github.fabriciolfj.crudperson.application.api;

import com.github.fabriciolfj.crudperson.core.ports.out.dto.PersonResponse;
import com.github.fabriciolfj.crudperson.core.ports.in.dto.PersonRequest;
import com.github.fabriciolfj.crudperson.core.ports.in.PersonCrudIn;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonCrudIn personCrudIn;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public PersonResponse save(@RequestBody final PersonRequest request) {
        return personCrudIn.save(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<PersonResponse> findAll() {
        return personCrudIn.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public PersonResponse findById(@PathVariable("id") final Long id) {
        return personCrudIn.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") final Long id, @RequestBody final PersonRequest request) {
        personCrudIn.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") final Long id) {
        personCrudIn.delete(id);
    }
}
