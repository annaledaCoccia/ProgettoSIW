package it.uniroma3.spring.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import it.uniroma3.spring.model.Attivita;

@Component
public class AttivitaValidator implements Validator {

	   @Override
	    public void validate(Object o, Errors errors) {
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nomeAttivita", "required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "data", "required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "orarioinizio", "required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "orariofine", "required");
	    }

	    @Override
	    public boolean supports(Class<?> aClass) {
	        return Attivita.class.equals(aClass);
	    }	
}
