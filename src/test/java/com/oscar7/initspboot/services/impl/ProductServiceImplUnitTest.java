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
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = false)
public class ProductServiceImplUnitTest {
    MockMvc mockMvc;
    @InjectMocks
    ProductServiceImpl productService;

    @Mock
    Pageable pageable;

    @Mock
    List<Product> products;

    @Test
    public void when_products_size_is_inferior_to_start_page_then_return_emptyList() {
        // Given
        final int pageSize = 1;
        final int currentPage = 1;
        final int startProductPage = 1;
        final List<Product> productList = Collections.emptyList();
        Mockito.doReturn(pageSize).when(pageable).getPageSize();
        Mockito.doReturn(currentPage).when(pageable).getPageNumber();
        Mockito.doReturn(productList).when(products).subList(Mockito.anyInt(), Mockito.anyInt());

        // When
        Page<Product> result = productService.findProductsPaginated(pageable);

        // Then
        Assert.assertEquals(startProductPage, result.getSize());
        Assert.assertTrue(products.size() < startProductPage);
        Assert.assertTrue(startProductPage < result.getTotalPages());
    }

    @Test
    public void when_find_products_paginated_then_return_page_list() {
        // Given
        int toIndex = 75;
        final int pageSize = 5;
        final int currentPage = 1;
        final int startProductPage = 5;//pageSize X currentPage
        Product product = Mockito.mock(Product.class);
        final List<Product> productList = new ArrayList<>();
        productList.add(product);
        Mockito.doReturn(pageSize).when(pageable).getPageSize();
        Mockito.doReturn(currentPage).when(pageable).getPageNumber();
        Mockito.doReturn(productList).when(products).subList(startProductPage, toIndex);
        // When
        Page<Product> result = productService.findProductsPaginated(pageable);

        // Then
        Assert.assertEquals(startProductPage, result.getSize());
        Assert.assertTrue(result.getTotalPages() > startProductPage);
        Assert.assertEquals(startProductPage, result.getContent().size());
        Assert.assertTrue(products.size() > startProductPage);
    }

    @Test
    public void return_product_when_id_is_not_null() {
        // Given
        final int id = 100001;
        Product product = Mockito.mock(Product.class);
        final List<Product> productList = new ArrayList<>();
        productList.add(product);
        Mockito.doReturn(id).when(product).getId();
        Mockito.doReturn(productList).when(products).subList(Mockito.anyInt(), Mockito.anyInt());
        // When
        Product result = productService.findProductById(id);

        // Then
        Assert.assertEquals(id, result.getId());
    }
    @Test
    public void return_null_when_id_is_not_existe() {
        // Given
        final int id = 1;
        Product product = Mockito.mock(Product.class);
        final List<Product> productList = new ArrayList<>();
        productList.add(product);
        //Mockito.doReturn(null).when(product).getId();
        Mockito.doReturn(productList).when(products).subList(Mockito.anyInt(), Mockito.anyInt());
        // When
        Product result = productService.findProductById(id);

        // Then
        Assert.assertNull("Aucun produit à un id égale à " + id,result);


    }


}
