package com.croz.jokes.validator;

import com.croz.jokes.entities.Joke;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class JokeValidator implements Validator {

    @Override
    public boolean supports(Class clazz) {

        return Joke.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content",
                "required.address", "Field name is required.");
    }
}
