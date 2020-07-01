package com.oscar7.initspboot.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@RequiredArgsConstructor
//@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppUser {
     Long userId;
     String userName;
     String firstName;
     String lastName;
     boolean enabled;
     String gender;
     String email;
     String encrytedPassword;

     String countryCode;

}
