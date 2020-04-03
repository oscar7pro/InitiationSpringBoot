package com.oscar7.initspboot.services.impl;

import com.oscar7.initspboot.entities.Product;
import com.oscar7.initspboot.repository.ProductRepository;
import com.oscar7.initspboot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    Product getProductsRepository(final List<Product> products, Pageable paging) {
        Product redPoivron = new Product();
        redPoivron.setId(1);
        redPoivron.setName("Poivron rouge");
        redPoivron.setDescription("Le kilo de poivron rouge");
        redPoivron.setQuantity(80555);
        redPoivron.setPrice(1.99);
        products.add(redPoivron);

        Product greenProduct = new Product();
        greenProduct.setId(2);
        greenProduct.setName("Poivron vert");
        greenProduct.setDescription("Le kilo de poivron vert");
        greenProduct.setPrice(1.89);
        greenProduct.setQuantity(51000);
        products.add(greenProduct);

        Product gProduct = new Product();
        gProduct.setId(3);
        gProduct.setName("pomme de terre");
        gProduct.setDescription("Le kilo de pomme de terre");
        gProduct.setPrice(1.59);
        gProduct.setQuantity(91000);
        products.add(gProduct);

        Product greProduct = new Product();
        greProduct.setId(4);
        greProduct.setName("Poivre noire");
        greProduct.setDescription("Le kilo de poivre noire");
        greProduct.setPrice(2.89);
        greProduct.setQuantity(571000);
        products.add(greProduct);

        Product greeProduct = new Product();
        greeProduct.setId(5);
        greeProduct.setName("Oignon");
        greeProduct.setDescription("Le kilo d'oignon");
        greeProduct.setPrice(1.75);
        greeProduct.setQuantity(581000);
        products.add(greeProduct);


        Product yellowProduct = new Product();
        yellowProduct.setId(6);
        yellowProduct.setName("Gombo vert");
        yellowProduct.setQuantity(589000);
        yellowProduct.setDescription("Le kilo de gombo vert");
        yellowProduct.setPrice(1.79);
        products.add(yellowProduct);

        Product blackProduct = new Product();
        blackProduct.setId(7);
        blackProduct.setName("Patate douce jaune");
        blackProduct.setQuantity(559000);
        blackProduct.setDescription("Le kilo de patate douce");
        blackProduct.setPrice(1.69);
        products.add(blackProduct);

        Product tProduct = new Product();
        tProduct.setId(8);
        tProduct.setName("Pomme hybride");
        tProduct.setQuantity(100000);
        tProduct.setDescription("Le kilo de Pomme hybride");
        tProduct.setPrice(1.99);
        products.add(tProduct);

        Product mixtProduct = new Product();
        mixtProduct.setId(9);
        mixtProduct.setName("Pomme -Igname jaune");
        mixtProduct.setQuantity(59000);
        mixtProduct.setDescription("Le kilo de pome -Igname jaune");
        mixtProduct.setPrice(1.99);
        products.add(mixtProduct);

        return (Product) products;
    }


    /**
     * creation d'un produit
     *
     * @param product le produit
     */
    @Override
    public void createProduct(Product product) {
        if (product.getId() == 0) {
            product.setId(product.getId());
            product.setName(product.getName());
            product.setDescription(product.getDescription());
            product.setQuantity(product.getQuantity());
            product.setPrice(product.getPrice());
        }
    }

    /**
     * Mise à jour de produit
     *
     * @param id      identifiant
     * @param product le produit
     */
    @Override
    public void updateProduct(int id, Product product) {
        product.remove(id);
        product.setId(id);
    }

    /**
     * Suppression d'un produit
     *
     * @param id identifient produit
     */
    @Override
    public void deleteProduct(int id) {

    }

    /**
     * Suppression d'un produit
     *
     * @param id identifient produit
     */
    public void deleteProduct(int id, Product product) {
        product.remove(id);
    }

    /**
     * Lister les produits
     *
     * @return la liste des produits
     */
    @Override
    public List<Product> getProducts(final Product product, final Pageable pageable, final Integer pageNumber, final Integer pageSize, final String sortBy) {
        Pageable paging = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        //Page<Product> pageResult = repository.findAll(paging);
        return getProductsRepository(product, paging);
        /*if (pageResult.hasContent()) {
            return pageResult.getContent();
        } else {
            return getProductsRepository(product, paging);
        }*/
    }

    /**
     * Obtenir un produit par identifient
     *
     * @param id identifiant
     * @return le produit
     */
    @Override
    public Product getProductById(int id) {
        return null;
    }


    public Product getProductById(Product product) {
        return null;

    }


}
