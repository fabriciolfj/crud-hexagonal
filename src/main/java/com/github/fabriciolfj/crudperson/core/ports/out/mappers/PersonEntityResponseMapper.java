package com.github.fabriciolfj.crudperson.core.ports.out.mappers;

import com.github.fabriciolfj.crudperson.adapters.persistence.entity.PersonEntity;
import com.github.fabriciolfj.crudperson.core.ports.out.dto.PersonEntityResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonEntityResponseMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "document", target = "document")
    @Mapping(source = "type", target = "type")
    PersonEntityResponse toResponseEntity(final PersonEntity entity);
}
