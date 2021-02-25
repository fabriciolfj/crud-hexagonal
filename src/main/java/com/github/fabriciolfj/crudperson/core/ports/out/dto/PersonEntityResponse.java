package com.github.fabriciolfj.crudperson.core.ports.out.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonEntityResponse {

    private String name;
    private String type;
    private String document;
}
