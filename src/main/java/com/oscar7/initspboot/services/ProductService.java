package com.oscar7.initspboot.services;

import com.oscar7.initspboot.entities.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    /**
     * creation d'un produit
     *
     * @param product le produit
     */
    void createProduct(Product product);

    /**
     * Mise à jour de produit
     *
     * @param id      identifiant
     * @param product le produit
     */
    void updateProduct(int id, Product product);

    /**
     * Suppression d'un produit
     *
     * @param id identifient produit
     */
    void deleteProduct(int id);

    /**
     * Lister les produits
     *
     * @return la liuste des produits
     */
    public List<Product> getProducts(Product product, Pageable pageable, Integer pageNumber, Integer pageSize, String sortBy);

    /**
     * Obtenir un produit par identifient
     *
     * @param id identifiant
     * @return le produit
     */
    Product getProductById(int id);

}
