package com.uniovi.sdi2122805labspring.validators;

import com.uniovi.sdi2122805labspring.entities.Mark;
import com.uniovi.sdi2122805labspring.services.MarksService;
import com.uniovi.sdi2122805labspring.services.SecurityService;
import com.uniovi.sdi2122805labspring.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.*;


@Component
public class MarksValidator implements Validator {

    @Autowired
    private UsersService usersService;

    @Autowired
    private MarksService marksService;

    @Autowired
    SecurityService securityService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Mark.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Mark mark = (Mark) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dni", "Error.empty");

        if(mark.getScore() < 0 || mark.getScore() > 10){
            errors.rejectValue("score", "Error.marks.score.value");
        }

        if (mark.getDescription().length() < 20) {
            errors.rejectValue("description", "Error.marks.description.length");
        }
    }
}
