package com.oscar7.initspboot.services;

import com.oscar7.initspboot.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    public Page<Product> findProductsPaginated(Pageable pageable);

    /**
     * creation d'un produit
     *
     * @param product
     */
    public void addProduct(Product product);

    /**
     * recherche d'un produit par nom ou id
     *
     * @param id     l'identifient produit
     * @return le produit correspondant
     */
    Product findProductById(int id);

    /**
     * recherche d'un produit par nom ou id
     *
     * @param name     l'identifient produit
     * @return le produit correspondant
     */
    Product findProductByName(String name);
}
