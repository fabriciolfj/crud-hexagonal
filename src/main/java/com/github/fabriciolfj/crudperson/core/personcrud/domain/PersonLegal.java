package com.github.fabriciolfj.crudperson.core.personcrud.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonLegal extends Person {

    private String document;
    private String name;

    @Override
    public String getType() {
        return "Person Legal";
    }
}
