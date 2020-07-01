package com.oscar7.initspboot.services.impl;

import com.oscar7.initspboot.entities.Product;
import com.oscar7.initspboot.services.ProductService;
import com.oscar7.initspboot.utils.ProductUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.Iterator;
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

    /**
     * creation d'un produit
     *
     * @param product
     */
    @Override
    public void addProduct(Product product) {
        this.products.add(product);
    }

    /**
     * recherche d'un produit par id
     *
     * @return le produit correspondant
     */
    @Override
    public Product findProductById(final int id) {

        for(Product product: ProductUtils.buildProducts()) {
            if(product.getId() == id) {
                return product;
            }
        }
        return null;

    }

    /**
     * recherche d'un produit par nom ou id
     *
     * @param name l'identifient produit
     * @return le produit correspondant
     */
    @Override
    public Product findProductByName(String name) {
        return ProductUtils.buildProducts()
                .stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }



}
