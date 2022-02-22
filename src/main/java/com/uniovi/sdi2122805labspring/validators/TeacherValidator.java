package com.uniovi.sdi2122805labspring.validators;

import com.uniovi.sdi2122805labspring.entities.Teacher;
import com.uniovi.sdi2122805labspring.services.SecurityService;
import com.uniovi.sdi2122805labspring.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.*;


@Component
public class TeacherValidator implements Validator {

    @Autowired
    private UsersService usersService;

    @Autowired
    SecurityService securityService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Teacher.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Teacher teacher = (Teacher) target;
        String dniTeacher = teacher.getDni();

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dni", "Error.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "category", "Error.empty");

        if (usersService.getUserByDni(dniTeacher) != null) {
            errors.rejectValue("dni", "Error.teacher.dni.duplicate");
        }

        if(dniTeacher.length() != 9) {
            errors.rejectValue("dni", "Error.teacher.dni.length");
        }

        String lastLetter = dniTeacher.substring(dniTeacher.length() -1);
        if(!lastLetter.chars().allMatch(Character::isLetter)) {
            errors.rejectValue("dni", "Error.teacher.dni.lastletter");
        }
    }
}
