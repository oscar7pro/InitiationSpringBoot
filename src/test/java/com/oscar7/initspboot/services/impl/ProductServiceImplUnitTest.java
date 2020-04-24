package com.oscar7.initspboot.services.impl;
import com.oscar7.initspboot.config.ConfigProperties;
import com.oscar7.initspboot.entities.Category;
import com.oscar7.initspboot.entities.Person;
import com.oscar7.initspboot.entities.Product;
import com.oscar7.initspboot.services.CategoryService;
import com.oscar7.initspboot.services.PersonService;
import com.oscar7.initspboot.services.ProductService;
import com.oscar7.initspboot.utils.ProductUtils;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.servlet.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = false)
public class ProductServiceImplUnitTest {
    MockMvc mockMvc;
    @InjectMocks
    ProductServiceImpl productService;

    @Mock
    Pageable pageable;

    @Mock
    PageImpl page;

    @Test
    public void when_products_size_is_inferior_to_start_page_then_return_emptyList() {
        // Given
        final int pageSize = 2;
        final int currentPage = 1;
        final int startProductPage = 0;
        Product product = Mockito.mock(Product.class);
        final List<Product> productList = new ArrayList<>();
        Mockito.doReturn(pageSize).when(pageable).getPageSize();
        Mockito.doReturn(currentPage).when(pageable).getPageNumber();
        //Mockito.doReturn(startProductPage).when(currentPage*pageSize);

        Mockito.doReturn(productList).when(Mockito.anyList().isEmpty());
        // When
        Page<Product> result = productService.findProductsPaginated(pageable);

        // Then
        Assert.assertEquals(result.isEmpty(),result.getTotalPages());


    }
    @Test
    public void when_find_products_paginated_then_return_page_list() {
        // Given
        final int toIndex = 5;
        final int pageSize = 2;
        final int currentPage = 1;
        final int startProductPage = 0;
        Product product = Mockito.mock(Product.class);
        final List<Product> productList = new ArrayList<>();
        productList.add(product);
        Mockito.doReturn(pageSize).when(pageable).getPageSize();
        Mockito.doReturn(currentPage).when(pageable).getPageNumber();
        Mockito.doReturn(toIndex).when(Mockito.anyInt());


        Mockito.doReturn(productList).when(Mockito.anyList().subList(startProductPage,toIndex));
        // When
        Page<Product> result = productService.findProductsPaginated(pageable);

        // Then
        Assert.assertEquals(1, (result.getTotalPages()));


    }








}
