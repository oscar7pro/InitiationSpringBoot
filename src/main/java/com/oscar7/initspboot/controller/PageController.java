package com.oscar7.initspboot.controller;


import com.oscar7.initspboot.config.ConfigProperties;
import com.oscar7.initspboot.entities.Category;
import com.oscar7.initspboot.entities.Person;
import com.oscar7.initspboot.entities.Product;
import com.oscar7.initspboot.services.CategoryService;
import com.oscar7.initspboot.services.PersonService;
import com.oscar7.initspboot.services.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Controller
@RequiredArgsConstructor
public class PageController {

    ConfigProperties configProperties;

    PersonService personService;

    ProductService productService;

    CategoryService categoryService;

    @GetMapping(value = "/")
    public String home(Model model) {
        getProperties(model);
        return "index";
    }

    //@RequestMapping(value = "/persons", method = RequestMethod.GET)
    @GetMapping("/persons")
    public String getPersonList(Model model,
                              @RequestParam("page") Optional<Integer> page,
                              @RequestParam("size") Optional<Integer> size
    ) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(7);
        Page<Person> personPage = personService.findPersonsPaginated(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("personPage", personPage);
        int totalPages = personPage.getTotalPages();
        getPageNumbers(model, totalPages);
        return "personsPage.html";
    }

    @GetMapping(value = "/products")
    public String getProductList(final Model model,
                                 @RequestParam("page") Optional<Integer> page,
                                 @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);
        Page<Product> productPage = productService.findProductsPaginated(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("productPage", productPage);
        int totalPages = productPage.getTotalPages();
        getPageNumbers(model, totalPages);
        return "productsPage";

    }

    @GetMapping(value = "/categories")
    public String getCategoryList(final Model model,
                                  @RequestParam("page") Optional<Integer> page,
                                  @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        Page<Category> categoryPage = categoryService.findCategoriesPage(PageRequest.of(currentPage, pageSize));
        model.addAttribute("categoryPage", categoryPage);
        int totalPages = categoryPage.getTotalPages();
        getPageNumbers(model, totalPages);
        return "categoriesPage";

    }

    private void getPageNumbers(Model model, int totalPages) {
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
    }


    private void getProperties(Model model) {
        model.addAttribute("home", configProperties.getHome());
        model.addAttribute("deleteCategory", configProperties.getDeleteCategory());
        model.addAttribute("deletePerson", configProperties.getDeletePerson());
        model.addAttribute("editCategory", configProperties.getEditCategory());
        model.addAttribute("editPerson", configProperties.getEditPerson());
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