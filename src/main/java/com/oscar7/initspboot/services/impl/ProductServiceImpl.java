package com.oscar7.initspboot.services.impl;

import com.oscar7.initspboot.entities.Product;
import com.oscar7.initspboot.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    private static Map<Integer, Product> productRepo = new HashMap<>();
    static int maxId = 0;

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


    static {
        Product redPoivron = new Product();
        redPoivron.setId(1);
        redPoivron.setName("Poivron rouge");
        redPoivron.setDescription("Le kilo de poivron rouge");
        redPoivron.setQuantity(80555);
        redPoivron.setPrice(1.99);
        productRepo.put(redPoivron.getId(), redPoivron);

        Product greenProduct = new Product();
        greenProduct.setId(2);
        greenProduct.setName("Poivre vert");
        greenProduct.setDescription("Le kilo de poivron vert");
        greenProduct.setPrice(1.89);
        greenProduct.setQuantity(51000);
        productRepo.put(greenProduct.getId(), greenProduct);

        Product gProduct = new Product();
        gProduct.setId(2);
        gProduct.setName("Poivre vert");
        gProduct.setDescription("Le kilo de poivron vert");
        gProduct.setPrice(1.89);
        gProduct.setQuantity(51000);
        productRepo.put(gProduct.getId(), greenProduct);

        Product greProduct = new Product();
        greProduct.setId(2);
        greProduct.setName("Poivre vert");
        greProduct.setDescription("Le kilo de poivron vert");
        greProduct.setPrice(1.89);
        greProduct.setQuantity(51000);
        productRepo.put(greProduct.getId(), greenProduct);

        Product greeProduct = new Product();
        greeProduct.setId(2);
        greeProduct.setName("Poivre vert");
        greeProduct.setDescription("Le kilo de poivron vert");
        greeProduct.setPrice(1.89);
        greeProduct.setQuantity(51000);
        productRepo.put(greeProduct.getId(), greenProduct);


        Product yellowProduct = new Product();
        yellowProduct.setId(4);
        yellowProduct.setName("Poivre jaune");
        yellowProduct.setQuantity(59000);
        yellowProduct.setDescription("Le kilo de poivron vert");
        yellowProduct.setPrice(1.79);
        productRepo.put(yellowProduct.getId(), yellowProduct);

        Product blackProduct = new Product();
        blackProduct.setId(5);
        blackProduct.setName("Poivre jaune");
        blackProduct.setQuantity(59000);
        blackProduct.setDescription("Le kilo de poivron vert");
        blackProduct.setPrice(1.69);
        productRepo.put(blackProduct.getId(), blackProduct);

        Product tProduct = new Product();
        tProduct.setId(6);
        tProduct.setName("Poivre jaune");
        tProduct.setQuantity(59000);
        tProduct.setDescription("Le kilo de poivron vert");
        tProduct.setPrice(1.79);
        productRepo.put(tProduct.getId(), tProduct);

        Product mixtProduct = new Product();
        mixtProduct.setId(7);
        mixtProduct.setName("Poivre jaune");
        mixtProduct.setQuantity(59000);
        mixtProduct.setDescription("Le kilo de poivron vert");
        mixtProduct.setPrice(1.79);
        productRepo.put(mixtProduct.getId(), mixtProduct);

    }

    /**
     * creation d'un produit
     *
     * @param product le produit
     */
    @Override
    public void createProduct(Product product) {
        if (product.getId() == 0) {
            maxId++;
            product.setId(maxId);
        }
        productRepo.put(product.getId(), product);
    }

    /**
     * Mise à jour de produit
     *
     * @param id      identifiant
     * @param product le produit
     */
    @Override
    public void updateProduct(int id, Product product) {
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id, product);
    }

    /**
     * Suppression d'un produit
     *
     * @param id identifient produit
     */
    @Override
    public void deleteProduct(int id) {
        productRepo.remove(id);
    }

    /**
     * Lister les produits
     *
     * @return la liste des produits
     */
    @Override
    public List<Product> getProducts(final Product product, final Pageable pageable) {
        Pageable pag = PageRequest.of(0, 3);
        Page<Product> pageResult = (Page<Product>) getProductsRepository(product, pageable);
        return getProductsRepository(product, (Pageable) pageResult);
     /*   if(pageResult..hasContent()) {
            return pageResult.getContent();
        } else  {
            //return new ArrayList<Product>();
            return getProductsRepository(product, paging);
        }*/
    }

    @Override
    public Product getProductById(int id) {
        Product productId = productRepo.get(id);
        if (productId != null) {
            return productRepo.get(id);
        }
        throw new IllegalArgumentException("pas de produit " + productId);
    }

    @Override
    public Iterable<Product> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Product> S save(S products) {
        return null;
    }

    @Override
    public <S extends Product> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Product> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Product> findAll() {
        return null;
    }

    @Override
    public Iterable<Product> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Product product) {

    }

    @Override
    public void deleteAll(Iterable<? extends Product> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
