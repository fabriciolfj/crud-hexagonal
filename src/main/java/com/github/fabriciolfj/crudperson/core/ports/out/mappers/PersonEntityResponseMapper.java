package com.github.fabriciolfj.crudperson.core.ports.out.mappers;

import com.github.fabriciolfj.crudperson.adapters.persistence.entity.PersonEntity;
import com.github.fabriciolfj.crudperson.core.ports.out.dto.PersonEntityResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonEntityResponseMapper {

    PersonEntityResponse toResponseEntity(final PersonEntity entity);
}
