package com.oscar7.initspboot.services.impl;

import com.oscar7.initspboot.entities.Category;
import com.oscar7.initspboot.services.CategoryService;
import com.oscar7.initspboot.utils.CategoryUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    final List<Category> categories = CategoryUtils.buildCategories();

    @Override
    public Page<Category> findCategoriesPage(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startCategoryPage = currentPage * pageSize;
        List<Category> categoriesList;
        if (categories.size() < startCategoryPage) {
            categoriesList = Collections.emptyList();
        } else {
            int toindex = Math.min(startCategoryPage + pageSize, categories.size());
            categoriesList = categories.subList(startCategoryPage, toindex);
        }
        return new PageImpl<>(categoriesList, PageRequest.of(currentPage, pageSize), categories.size());
    }
}
