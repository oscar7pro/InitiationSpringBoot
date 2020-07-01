package com.oscar7.initspboot.services.impl;

import com.oscar7.initspboot.entities.Category;
import com.oscar7.initspboot.entities.Product;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RunWith(MockitoJUnitRunner.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryServiceImplUnitTest {
    @InjectMocks
    CategoryServiceImpl categoryService;

    @Mock
    Pageable pageable;

    @Test
    public void should_return_zero_category_to_lastpage() {
        // Given
        int pageSize = 5;
        int currentPage = 5;
        //products size = 25 < startProductPage = 30
        Mockito.doReturn(pageSize).when(pageable).getPageSize();
        Mockito.doReturn(currentPage).when(pageable).getPageNumber();

        // When
        Page<Category> result = categoryService.findCategoriesPage(pageable);

        //Then
        Assert.assertEquals(0, result.getContent().size());
    }

    @Test
    public void when_categories_size_is_inferior_to_start_page_then_return_emptyList() {
        // Given
        int pageSize = 12;
        int currentPage = 6;
        Mockito.doReturn(pageSize).when(pageable).getPageSize();
        Mockito.doReturn(currentPage).when(pageable).getPageNumber();

        // When
        Page<Category> result = categoryService.findCategoriesPage(pageable);

        //Then
        Assert.assertTrue(result.getContent().isEmpty());
    }

    @Test
    public void should_return_categories_page_list_if_categoriesList_is_not_null() {
        // Given
        int pageSize = 5;
        int currentPage = 1;
        Mockito.doReturn(pageSize).when(pageable).getPageSize();
        Mockito.doReturn(currentPage).when(pageable).getPageNumber();

        // When
        Page<Category> result = categoryService.findCategoriesPage(pageable);

        //Then
        Assert.assertEquals(5, result.getContent().size());
    }
}
