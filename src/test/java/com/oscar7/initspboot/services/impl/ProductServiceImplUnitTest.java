package com.oscar7.initspboot.services.impl;

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

import java.util.Collections;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = false)
public class ProductServiceImplUnitTest {
    @InjectMocks
    ProductServiceImpl productService;

    @Mock
    Pageable pageable;

    @Test
    public void should_return_three_products_to_last_page() {
        // Given
        final int pageSize = 12;
        final int currentPage = 6;
        //products size = 75 < startProductPage = 72
        Mockito.doReturn(pageSize).when(pageable).getPageSize();
        Mockito.doReturn(currentPage).when(pageable).getPageNumber();

        // When
        Page<Product> result = productService.findProductsPaginated(pageable);

        // Then
        Assert.assertEquals(3, result.getContent().size());
    }


    @Test
    public void when_products_size_is_inferior_to_start_page_then_return_emptyList() {
        // Given
        final int pageSize = 10;
        final int currentPage = 8;
        //final int startProductPage = 1;
        final List<Product> productList = Collections.emptyList();
        Mockito.doReturn(pageSize).when(pageable).getPageSize();
        Mockito.doReturn(currentPage).when(pageable).getPageNumber();

        // When
        Page<Product> result = productService.findProductsPaginated(pageable);

        // Then

        Assert.assertTrue(result.getContent().isEmpty());
    }

    @Test
    public void when_find_products_paginated_then_return_page_list() {
        // Given
        final int pageSize = 5;
        final int currentPage = 1;
        Mockito.doReturn(pageSize).when(pageable).getPageSize();
        Mockito.doReturn(currentPage).when(pageable).getPageNumber();

        // When
        Page<Product> result = productService.findProductsPaginated(pageable);

        // Then
        Assert.assertEquals(5, result.getContent().size());
    }

    @Test
    public void return_product_when_id_is_not_null() {
        // Given
        final int id = 100001;
        // When
        Product result = productService.findProductById(id);

        // Then
        Assert.assertEquals(id, result.getId());
    }

    @Test
    public void return_null_when_id_is_not_existe() {
        // Given
        final int id = 1;

        // When
        Product result = productService.findProductById(id);

        // Then
        Assert.assertNull("Aucun produit à un id égale à " + id, result);


    }


}
