package com.oscar7.initspboot.utils;

import com.oscar7.initspboot.entities.User;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUtils {
    static List<User> users = new ArrayList<>();
    static final int COUNT_USERS = 75;
    static final int MIN_COUNT_USERS = 1000;

    public static List<User> buildUsers() {
        if (users.isEmpty()) {
            IntStream.range(0, COUNT_USERS).forEach(n -> {
                users.add(new User(MIN_COUNT_USERS + n + 1, "dalhia@oscar7pro.com", "test", "Kimasch", "Dalhia", false, ""));
            });
        }
        return users;
    }


}
