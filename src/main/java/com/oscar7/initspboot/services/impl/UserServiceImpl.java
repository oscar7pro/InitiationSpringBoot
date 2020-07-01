package com.oscar7.initspboot.services.impl;

import com.oscar7.initspboot.dto.UserDto;
import com.oscar7.initspboot.entities.User;
import com.oscar7.initspboot.services.UserService;
import com.oscar7.initspboot.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

@Service("userService")
public class UserServiceImpl implements UserService {
    User user = new User();

    @Override
    public UserDto showRegistrationForm() {
        UserDto user = new UserDto();
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setPassword(user.getPassword());
        user.setMatchingPassword(user.getMatchingPassword());

        return user;
    }

    @Override
    public User findUserByEmail(String email) {
        return user.getEmail().equals(email) ? user : null;
       /* if(user.getEmail().equals(email)) {
           return user;
        }
        return null;*/
    }

    @Override
    public User findUserByConfirmationToken(String confirmationToken) {
        return UserUtils.buildUsers()
                .stream()
                .filter(user -> user.getConfirmationToken().equalsIgnoreCase(confirmationToken))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void saveUser(User user) {
        save(user);
    }

    private User save(User user) {
        user.setId(user.getId());
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setPassword(user.getPassword());
        user.setEmail(user.getEmail());
        user.setConfirmationToken(user.getConfirmationToken());
        UserUtils.buildUsers().add(user);
        return user;
    }

}
