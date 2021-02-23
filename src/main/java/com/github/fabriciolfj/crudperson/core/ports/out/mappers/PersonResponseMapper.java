package com.github.fabriciolfj.crudperson.core.ports.out.mappers;

import com.github.fabriciolfj.crudperson.core.ports.out.dto.PersonResponse;
import com.github.fabriciolfj.crudperson.core.ports.out.mappers.impl.PersonResponseMapperDecorated;
import com.github.fabriciolfj.crudperson.core.personcrud.domain.Person;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
@DecoratedWith(PersonResponseMapperDecorated.class)
public interface PersonResponseMapper {

    PersonResponse toResponse(final Person person);
}
