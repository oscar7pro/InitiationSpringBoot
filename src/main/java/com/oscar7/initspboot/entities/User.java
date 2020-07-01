package com.oscar7.initspboot.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Transient;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    int id;

    @Email(message = "Please provide a valid e-mail")
    @NotEmpty(message = "Please provide an e-mail")
    String email;

    @Transient
    String password;

    @NotEmpty(message = "Please provide your first name")
    String firstName;

    @NotEmpty(message = "Please provide your last name")
    String lastName;

    boolean enabled;

    String confirmationToken;
}
