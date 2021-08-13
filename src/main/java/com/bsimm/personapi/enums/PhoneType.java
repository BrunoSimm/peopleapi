package com.bsimm.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {

	HOME("Home"),
	MOBILE("Mobilme"),
	COMMERCIAL("Comercial");
	
	private final String description;
	
}
