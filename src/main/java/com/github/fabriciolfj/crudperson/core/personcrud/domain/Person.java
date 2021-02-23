package com.github.fabriciolfj.crudperson.core.personcrud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Person {

    public abstract String getName();
    public abstract String getDocument();
    public abstract String getType();
}
