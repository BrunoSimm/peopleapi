package com.bsimm.personapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bsimm.personapi.dto.request.PersonDTO;
import com.bsimm.personapi.entity.Person;
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

}
