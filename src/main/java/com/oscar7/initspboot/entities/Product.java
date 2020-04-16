package com.oscar7.initspboot.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.*;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @NotNull( message = "La reference est compris entre 1 et 10000")
    int id;

    @Size(min = 5, max = 200, message = "le nom doit comprends 5 caracteres minimum")
    String name;

    @Size(min = 5, max = 200, message = "le nom doit comprends 5 caracteres minimum")
    String description;

    @NotNull( message = "La quantité est different de null")
    int quantity;

    @Positive(message = "le prix est toujours non nul et positif")
    Double price;
}
