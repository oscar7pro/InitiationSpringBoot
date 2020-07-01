package com.oscar7.initspboot.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@RequiredArgsConstructor
//@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Country {
    String countryCode;
    String countryName;
}
