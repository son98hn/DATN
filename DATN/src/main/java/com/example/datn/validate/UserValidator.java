package com.example.datn.validate;

import com.example.datn.dto.UserDTO;
import com.example.datn.entity.UserEntity;
import com.example.datn.service.impl.UserService;
import org.apache.commons.validator.EmailValidator;
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
    private final EmailValidator emailValidator = EmailValidator.getInstance();

    private final UserService userService;

    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass == UserDTO.class;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO userDTO = (UserDTO) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email","Email is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "", "User name is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "", "First name is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "", "Last name is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "", "Password is required");

        if(errors.hasErrors())
            return;

        if (!emailValidator.isValid(userDTO.getEmail())) {
            errors.rejectValue("email","Email is not valid");
            return;
        }

        UserEntity userAccount = userService.findByUserName( userDTO.getUsername());
        if (userAccount != null) {
            if (userDTO.getUserId() == null) {
                errors.rejectValue("userName", "", "User name is not available");
                return;
            } else if (!userDTO.getUserId().equals(userAccount.getId() )) {
                errors.rejectValue("userName", "", "User name is not available");
                return;
            }
        }

        userAccount = userService.findByUserName(userDTO.getEmail());
        if (userAccount != null) {
            if (userDTO.getUserId() == null) {
                errors.rejectValue("email", "", "Email is not available");
            } else if (!userDTO.getUserId().equals(userAccount.getId() )) {
                errors.rejectValue("email", "", "Email is not available");
            }
        }
    }
}
