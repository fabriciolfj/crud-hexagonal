package com.github.fabriciolfj.crudperson.adapters.persistence.mapper;

import com.github.fabriciolfj.crudperson.adapters.persistence.entity.PersonEntity;
import com.github.fabriciolfj.crudperson.adapters.persistence.mapper.impl.PersonEntityMapperDecorated;
import com.github.fabriciolfj.crudperson.core.personcrud.domain.Person;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
@DecoratedWith(PersonEntityMapperDecorated.class)
public interface PersonEntityMapper {

    PersonEntity toEntity(final Person person);
}
