package com.bsimm.personapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsimm.personapi.dto.request.PersonDTO;
import com.bsimm.personapi.entity.Person;
import com.bsimm.personapi.exception.PersonNotFoundException;
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
	
	public Person updateById(Person person, Long id) throws PersonNotFoundException{
		
		verifyIfExists(id);
		
		if (person.getId() == null) {
			person.setId(id);
		} 
		
        return this.personRepository.save(person);
    }
	
	public List<Person> listAll(){
		return this.personRepository.findAll();
	}

	public PersonDTO findById(Long id) throws PersonNotFoundException {

		Person person  = verifyIfExists(id);
		
		PersonDTO personDTO = new PersonDTO();
		return personDTO.toDTO(person);
		
				/*new PersonDTO(
					optionalPerson.get().getId(), optionalPerson.get().getFirstName(),
					optionalPerson.get().getLastName(), optionalPerson.get().getCpf(), 
					optionalPerson.get().getBirthDate(), optionalPerson.get().getPhones()
				);*/
	}

	public void deleteById(Long id) throws PersonNotFoundException {
		//Verificando se a person existe
		verifyIfExists(id);
		
		this.personRepository.deleteById(id);
	}

	private Person verifyIfExists(Long id) throws PersonNotFoundException {
		return this.personRepository.findById(id)
				.orElseThrow(() -> new PersonNotFoundException(id));
	}
	
	
}
