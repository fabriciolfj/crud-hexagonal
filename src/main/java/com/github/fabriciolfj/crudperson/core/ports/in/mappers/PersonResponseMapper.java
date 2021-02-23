package com.github.fabriciolfj.crudperson.core.ports.in.mappers;

import com.github.fabriciolfj.crudperson.core.ports.in.dto.PersonResponse;
import com.github.fabriciolfj.crudperson.core.ports.in.mappers.impl.PersonResponseMapperDecorated;
import com.github.fabriciolfj.crudperson.core.personcrud.domain.Person;
import com.github.fabriciolfj.crudperson.core.ports.out.dto.PersonEntityResponse;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
@DecoratedWith(PersonResponseMapperDecorated.class)
public interface PersonResponseMapper {

    PersonResponse toResponse(final Person person);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "document", source = "document")
    @Mapping(target = "type", source = "type")
    PersonResponse toResponse(final PersonEntityResponse entityResponse);
}
