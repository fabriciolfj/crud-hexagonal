package com.github.fabriciolfj.crudperson.adapters.persistence.repository;

import com.github.fabriciolfj.crudperson.adapters.persistence.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}
