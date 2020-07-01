package com.oscar7.initspboot.validator;

import com.oscar7.initspboot.dao.AppUserDAO;
import com.oscar7.initspboot.entities.AppUser;
import com.oscar7.initspboot.form.AppUserForm;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppUserValidator implements Validator {
    //common-validator library
    EmailValidator emailValidator = EmailValidator.getInstance();

    @Autowired
    AppUserDAO appUserDAO;

    //The classes are supported by this validator
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == AppUserForm.class;
    }


    @Override
    public void validate(Object target, Errors errors) {
        AppUserForm appUserForm = (AppUserForm) target;

        //Check the fields of AppUserForm
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty.appUserForm.userName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty.appUserForm.firstName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty.appUserForm.lastName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.appUserForm.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.appUserForm.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "NotEmpty.appUserForm.confirmPassword");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "NotEmpty.appUserForm.gender");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "countryCode", "NotEmpty.appUserForm.countryCode");

        if (!this.emailValidator.isValid(appUserForm.getEmail())) {
            //Invalid email
            errors.rejectValue("email", "Pattern.appUserForm.email");
        } else if (appUserForm.getUserId() == null) {
            AppUser dbUser = appUserDAO.findAppUserByNameAppUser(appUserForm.getEmail());
            if (dbUser != null) {
                //Email has been used by another account
                errors.rejectValue("email", "Duplicate.appUserForm.email");
            }
        }

        if (!errors.hasFieldErrors("userName")) {
            AppUser dbUser = appUserDAO.findAppUserByNameAppUser(appUserForm.getUserName());
            if (dbUser != null) {
                // Username is not availabl
                errors.rejectValue("userName", "Duplicate.appUserForm.userName");
            }
        }

        if (!errors.hasErrors()) {
            if (!appUserForm.getConfirmPassword().equals(appUserForm.getPassword())) {
                errors.rejectValue("confirmPassword", "Match.appUserForm.confirmPassword");

            }
        }

    }
}
