package com.oscar7.initspboot.dao;

import com.oscar7.initspboot.entities.AppUser;
import com.oscar7.initspboot.entities.Gender;
import com.oscar7.initspboot.form.AppUserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class AppUserDAO {
    @Autowired
    PasswordEncoder passwordEncoder;
    static final Map<Long, AppUser> USERS_MAP = new HashMap<>();

    static {
        initDATA();
    }

    private static void initDATA() {
        String encrytedPassword = "";
        AppUser tom = new AppUser(1L, "tom", "Tom", "Tom", true, Gender.MALE, "tom@waltdisney.com", encrytedPassword, "US");
        AppUser jerry = new AppUser(1L, "jerry", "jerry", "jerry", true, Gender.MALE, "jerry@waltdisney.com", encrytedPassword, "US");

        USERS_MAP.put(tom.getUserId(), tom);
        USERS_MAP.put(jerry.getUserId(), jerry);
    }

    public Long getMaxUserId() {
        long max = 0;
        for (Long id : USERS_MAP.keySet()) {
            if (id > max) {
                max = id;
            }
        }
        return max;
    }

    //
    public AppUser findAppUserByNameAppUser(final String email) {
        Collection<AppUser> appUsers = USERS_MAP.values();
        for (AppUser user : appUsers) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public List<AppUser> getAppUsers() {
        List<AppUser> list = new ArrayList<>();
        list.addAll(USERS_MAP.values());
        return list;
    }

    public AppUser createAppUser(AppUserForm form) {
        Long userId = this.getMaxUserId() + 1;
        String encryptedPassword = this.passwordEncoder.encode(form.getPassword());

        AppUser user = new AppUser(userId, form.getUserName(), form.getFirstName(), form.getLastName(), false,
                form.getGender(), form.getEmail(), form.getCountryCode(), encryptedPassword);
        USERS_MAP.put(userId, user);
        return user;

    }
}
