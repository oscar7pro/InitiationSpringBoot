package com.oscar7.initspboot.controller;


import com.oscar7.initspboot.config.ConfigProperties;
import com.oscar7.initspboot.entities.Product;
import com.oscar7.initspboot.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PageController {

    @Autowired
    private ConfigProperties configProperties;

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/")
    public String home(Model model) {
        getProperties(model);
        return "index";
    }

    /*@GetMapping(value = "/products")
    public ResponseEntity<Object> getProduct() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }*/

    @GetMapping(value = "/products")
    public String getProductList(final Model model, @NotNull Product product,
                                 @RequestParam(defaultValue = "0") Integer pageNumber,
                                 @RequestParam(defaultValue = "3") Integer pageSize,
                                 @RequestParam(defaultValue = "0") String sortBy) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).ascending());
        List<Product> allProduct = productService.getProducts(product, pageable);
        model.addAttribute("products", allProduct);
        return "productsPage";
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    // @PutMapping(value = "/products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
        productService.updateProduct(id, product);
        return new ResponseEntity<>("Mise à jour du produit avec succès", HttpStatus.OK);
    }

    @RequestMapping(value = "product/{id}", method = RequestMethod.DELETE)
    //@DeleteMapping(value = "product/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") int id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Le produit a été supprimé avec succès ", HttpStatus.OK);
    }

    @PostMapping(value = "/products")
    //@RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return new ResponseEntity<>("Le produit a été ajouté avec succès: ", HttpStatus.CREATED);
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