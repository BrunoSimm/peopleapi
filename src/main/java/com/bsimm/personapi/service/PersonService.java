package com.bsimm.personapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsimm.personapi.dto.request.PersonDTO;
import com.bsimm.personapi.entity.Person;
import com.bsimm.personapi.repository.PersonRepository;

@Service
public class PersonService {
	
	private PersonRepository personRepository;

	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public Person createPerson(Person person){
        return this.personRepository.save(person);
    }
	
	public Person updatePerson(Person person){
        return this.personRepository.save(person);
    }
	
	
	
}
