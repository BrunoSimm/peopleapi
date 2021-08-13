package com.bsimm.personapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bsimm.personapi.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
