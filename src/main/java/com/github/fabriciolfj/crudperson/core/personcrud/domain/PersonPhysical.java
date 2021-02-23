package com.github.fabriciolfj.crudperson.core.personcrud.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonPhysical extends Person {

    private String document;
    private String name;

    @Override
    public String getType() {
        return "Person Physical";
    }
}
