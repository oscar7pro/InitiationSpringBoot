package com.oscar7.initspboot.services.impl;

import com.oscar7.initspboot.entities.Product;
import com.oscar7.initspboot.services.ProductService;
import com.oscar7.initspboot.utils.ProductUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    final List<Product> products = ProductUtils.buildProducts();


    @Override
    public Page<Product> findProductsPaginated(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startProductPage = currentPage * pageSize;
        List<Product> productList;
        if (products.size() < startProductPage) {
            productList = Collections.emptyList();
        } else {
            int toIndex = Math.min(startProductPage + pageSize, products.size());
            productList = products.subList(startProductPage, toIndex);
        }
        return new PageImpl<>(productList, PageRequest.of(currentPage, pageSize), products.size());
    }
}
