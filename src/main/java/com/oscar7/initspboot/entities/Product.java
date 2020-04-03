package com.oscar7.initspboot.entities;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Product extends ArrayList<Product> {
    private int id;
    private String name;
    private String description;
    private int quantity;
    private Double price;
}
