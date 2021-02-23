package com.github.fabriciolfj.crudperson.application.mappers;

import com.github.fabriciolfj.crudperson.application.dto.PersonResponse;
import com.github.fabriciolfj.crudperson.application.mappers.impl.PersonResponseMapperDecorated;
import com.github.fabriciolfj.crudperson.core.personcrud.domain.Person;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
@DecoratedWith(PersonResponseMapperDecorated.class)
public interface PersonResponseMapper {

    PersonResponse toResponse(final Person person);
}
