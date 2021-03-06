package com.bsimm.personapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends Exception {
	
	public PersonNotFoundException(Long id) {
		super("Person not found with ID "+ id);
	}
	

}
