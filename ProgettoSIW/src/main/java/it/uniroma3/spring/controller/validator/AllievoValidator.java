package it.uniroma3.spring.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.spring.model.Allievo;

@Component
public class AllievoValidator implements Validator {

	   @Override
	    public void validate(Object o, Errors errors) {
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cognome", "required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dataDiNascita", "required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "luogoDiNascita", "required");
	    }

	    @Override
	    public boolean supports(Class<?> aClass) {
	        return Allievo.class.equals(aClass);
	    }	
}
