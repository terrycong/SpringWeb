package com.hsbc.test.web.domain;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserRegValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {

		return true;
//				User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username",
				"BLANK_ERROR");
	}
}
