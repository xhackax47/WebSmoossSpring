package com.aplose.smooss.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.aplose.smooss.model.User;
import com.aplose.smooss.services.UserService;

@Component
public class UserValidator implements Validator{
	@Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

	@Override
	public void validate(Object o, Errors errors) {
		
		User user = (User) o;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty", "*Veuillez entrer un email.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty", "*Veuillez entrer un prénom.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty", "*Veuillez entrer un nom.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty", "*Veuillez entrer un mot de passe.");

        if ( userService.findUserByEmail(user.getEmail()) != null ) {
            errors.reject("email", "*Addresse mail déjà utilisé.");
        }
        
        if ( !user.getPasswordConf().equals(user.getPassword()) ) {
            errors.reject("passwordConf", "*Vos mots de passes ne correspondent pas.");
        }
	}

}