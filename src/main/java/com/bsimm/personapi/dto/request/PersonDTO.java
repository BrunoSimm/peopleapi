package com.bsimm.personapi.dto.request;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.bsimm.personapi.entity.Person;
import com.bsimm.personapi.entity.Phone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
	
	 private Long id;
	    
	 @NotEmpty
	 @Size(min = 2, max = 100)
	 private String firstName;
	  
	 @NotEmpty
	 @Size(min = 2, max = 100)
	 private String lastName;
	    
	 @NotEmpty
	 private String cpf;
	 
	 @Past
	 private LocalDate birthDate;
	 
	 @NotEmpty
	 @Valid
	 private List<Phone> phones;
	 
	 public Person toModel() {
		 return new Person(this.id, this.firstName, this.lastName, this.cpf, this.birthDate, this.phones);
	 }
	
}
