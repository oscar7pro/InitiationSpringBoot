package com.oscar7.initspboot.config;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties(prefix = "app")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ConfigProperties {


    String title;
    String logo;
    String legende;
    String login;

    String prestation;
    String offrePublic;
    String offreProf;
    String offreParticulier;

    String products;
    String deleteCategory;
    String deletePerson;
    String addProduct;
    String editProduct;
    String deleteProduct;
    String editPerson;
    String editCategory;
    String home;
    String category;
    String addCategory;
    String newProductCategory;
    String bestProductCategory;
    String addCompany;
    String addToWishList;
    String deleteWishList;
    String orderList;
    String addToContact;
    String productList;
    String presentlyAddToCardProductList;
    String recentlyEditProductList;
    String outOfStockProduct;
    String outOfStockCategory;
    String categorytList;
    String promotionCategories;
    String updateAttributesCategorie;
    String addBillingAddress;
    String pointOfServices;
    String sanitizedMonitoring;
    String OthersService;


}

