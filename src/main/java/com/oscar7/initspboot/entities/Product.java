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

    @NegativeOrZero( message = "Zéro exclut ou non negatif")
    int id;

    @Size(min = 5, max = 200, message = "Completer le nom")
    String name;

    @Size(min = 5, max = 200, message = "Completer la decription")
    String description;

    int quantity;

    Double price;
}
