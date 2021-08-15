package com.bsimm.personapi.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bsimm.personapi.dto.request.PersonDTO;
import com.bsimm.personapi.entity.Person;
import com.bsimm.personapi.exception.PersonNotFoundException;
import com.bsimm.personapi.service.PersonService;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

	private PersonService personService;
	
	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
    public Person createPerson(@RequestBody @Valid PersonDTO personDTO){
        return this.personService.createPerson(personDTO.toModel());
    }
	
	@PutMapping
	@ResponseStatus(code = HttpStatus.CREATED)
    public Person updatePerson(@RequestBody @Valid PersonDTO personDTO){
        return this.personService.updatePerson(personDTO.toModel());
    }
	
	@GetMapping
	public List<PersonDTO> listAll(){
		List<PersonDTO> allDtoPeople = this.personService.listAll().stream()
				.map(person -> {
					return new PersonDTO(person.getId(), person.getFirstName(), person.getLastName(), person.getCpf(), person.getBirthDate(), person.getPhones());
				})
				.collect(Collectors.toList());

		return allDtoPeople;
	}
	
	@GetMapping("/{id}")
	public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
		return this.personService.findById(id);
	}

}
