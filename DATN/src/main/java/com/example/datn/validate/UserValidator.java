package com.example.datn.validate;

import org.apache.commons.validator.EmailValidator;
import com.example.datn.dto.UserForm;
import com.example.datn.entity.UserEntity;
import com.example.datn.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author: Pham Ngoc Son
 * <p>
 * Oct 04, 2021
 */
@Component
public class UserValidator implements Validator {
    private EmailValidator emailValidator = EmailValidator.getInstance();

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass == UserForm.class;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserForm userForm = (UserForm) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email","Email is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "", "User name is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "", "First name is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "", "Last name is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "", "Password is required");

        if(errors.hasErrors())
            return;

        if (!emailValidator.isValid(userForm.getEmail())) {
            errors.rejectValue("email","Email is not valid");
            return;
        }

        UserEntity userAccount = userService.findByUserName( userForm.getUserName());
        if (userAccount != null) {
            if (userForm.getUserId() == null) {
                errors.rejectValue("userName", "", "User name is not available");
                return;
            } else if (!userForm.getUserId().equals(userAccount.getId() )) {
                errors.rejectValue("userName", "", "User name is not available");
                return;
            }
        }

        userAccount = userService.findByUserName(userForm.getEmail());
        if (userAccount != null) {
            if (userForm.getUserId() == null) {
                errors.rejectValue("email", "", "Email is not available");
                return;
            } else if (!userForm.getUserId().equals(userAccount.getId() )) {
                errors.rejectValue("email", "", "Email is not available");
                return;
            }
        }
    }
}
