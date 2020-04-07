package com.oscar7.initspboot.services;

import com.oscar7.initspboot.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    public Page<Category> findCategoriesPage(Pageable pageable);
}
