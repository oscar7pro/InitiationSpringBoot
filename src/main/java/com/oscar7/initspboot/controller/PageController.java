package com.oscar7.initspboot.controller;


import com.oscar7.initspboot.config.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @Autowired
    private ConfigProperties configProperties;

    @GetMapping(value = "/")
    public String home(Model model) {
        getProperties(model);
        return "index";
    }

    private void getProperties(Model model) {
        model.addAttribute("logo", configProperties.getLogo());
        model.addAttribute("legend", configProperties.getLegende());
        model.addAttribute("title", configProperties.getTitle());
        model.addAttribute("login", configProperties.getLogin());

        model.addAttribute("offreParticulier", configProperties.getOffreParticulier());
        model.addAttribute("offreProf", configProperties.getOffreProf());
        model.addAttribute("prestation", configProperties.getPrestation());
        model.addAttribute("offrePublic", configProperties.getOffrePublic());

        model.addAttribute("products", configProperties.getProducts());
        model.addAttribute("category", configProperties.getCategory());

        model.addAttribute("addProduct", configProperties.getAddProduct());
        model.addAttribute("deleteProduct", configProperties.getDeleteProduct());
        model.addAttribute("editProduct", configProperties.getEditProduct());
        model.addAttribute("addCategory", configProperties.getAddCategory());
        model.addAttribute("newProductCategory", configProperties.getNewProductCategory());
        model.addAttribute("bestProductCategory", configProperties.getBestProductCategory());
        model.addAttribute("addCompany", configProperties.getAddCompany());
        model.addAttribute("deleteWishList", configProperties.getDeleteWishList());
        model.addAttribute("orderList", configProperties.getOrderList());
        model.addAttribute("addToContact", configProperties.getAddToContact());
        model.addAttribute("recentlyEditProductList", configProperties.getRecentlyEditProductList());
        model.addAttribute("presentlyAddToCardProductList", configProperties.getPresentlyAddToCardProductList());
        model.addAttribute("outOfStockProduct", configProperties.getOutOfStockProduct());
        model.addAttribute("productList", configProperties.getProductList());
        model.addAttribute("categorytList", configProperties.getCategorytList());
        model.addAttribute("promotionCategories", configProperties.getPromotionCategories());
        model.addAttribute("updateAttributesCategorie", configProperties.getUpdateAttributesCategorie());
        model.addAttribute("outOfStockCategory", configProperties.getOutOfStockCategory());
        model.addAttribute("addBillingAddress", configProperties.getAddBillingAddress());
        model.addAttribute("geolocalizedPointOfServiceList", configProperties.getPointOfServices());
        model.addAttribute("sanitizedMonitoring", configProperties.getSanitizedMonitoring());
        model.addAttribute("OthersService", configProperties.getOthersService());
    }
}