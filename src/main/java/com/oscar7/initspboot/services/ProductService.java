package com.oscar7.initspboot.services;

import com.oscar7.initspboot.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    public Page<Product> findProductsPaginated(Pageable pageable);

}
