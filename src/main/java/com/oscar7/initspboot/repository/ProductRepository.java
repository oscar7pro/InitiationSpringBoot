package com.oscar7.initspboot.repository;

import com.oscar7.initspboot.entities.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
}
