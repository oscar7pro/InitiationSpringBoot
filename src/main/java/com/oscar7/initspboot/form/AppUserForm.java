package com.oscar7.initspboot.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
//@NoArgsConstructor
@Data
public class AppUserForm {
    Long userId;
    String userName;
    String firstName;
    String lastName;
    boolean enabled;
    String gender;
    String email;
    String password;
    String confirmPassword;
    String countryCode;
}
