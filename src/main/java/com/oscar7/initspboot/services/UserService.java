package com.oscar7.initspboot.services;

import com.oscar7.initspboot.dto.UserDto;
import com.oscar7.initspboot.entities.User;

public interface UserService {
    UserDto showRegistrationForm();

    User findUserByEmail(String email);

    User findUserByConfirmationToken(String confirmationToken);

    void saveUser(User user);

}
