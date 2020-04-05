package com.oscar7.initspboot.utils;

import com.oscar7.initspboot.entities.Product;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductUtils {
    static List<Product> products = new ArrayList<>();
    static final int COUNT_PRODUCTS = 75;
    static final int MIN_COUNT_PRODUCTS = 100000;

    public static List<Product> buildProducts() {
        if (products.isEmpty()) {
            IntStream.range(0, COUNT_PRODUCTS).forEach(n -> {
                products.add(new Product(MIN_COUNT_PRODUCTS + n + 1, "Produit bio", "Alimentation saine", 150000, 1.99));
            });
        }
        return products;

    }
}
