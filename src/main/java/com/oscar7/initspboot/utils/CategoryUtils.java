package com.oscar7.initspboot.utils;

import com.oscar7.initspboot.entities.Category;
import com.oscar7.initspboot.entities.Product;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@FieldDefaults(level = AccessLevel.PRIVATE)

public class CategoryUtils {
    final static List<Category> categories = new ArrayList<>();

    static int COUNT_CATEGORIES = 25;
    static int MIN_COUNT_CATEGORIES = 137679;

    public static List<Category> buildCategories() {
        if (categories.isEmpty()) {
            IntStream.range(0, COUNT_CATEGORIES).forEach(n -> {
                categories.add(new Category(MIN_COUNT_CATEGORIES + n + 1, "Alimentation pures bio", ProductUtils.buildProducts().subList(0, 2)));
            });
        }
        return categories;
    }
}
