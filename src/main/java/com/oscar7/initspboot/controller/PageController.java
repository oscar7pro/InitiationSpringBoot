package com.oscar7.initspboot.controller;


import com.oscar7.initspboot.config.ConfigProperties;
import com.oscar7.initspboot.entities.Category;
import com.oscar7.initspboot.entities.Person;
import com.oscar7.initspboot.entities.Product;
import com.oscar7.initspboot.services.CategoryService;
import com.oscar7.initspboot.services.PersonService;
import com.oscar7.initspboot.services.ProductService;
import com.oscar7.initspboot.utils.ProductUtils;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Log
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Controller
@RequiredArgsConstructor
public class PageController {

    private static final String REDIRECT = "redirect:/";
    ConfigProperties configProperties;

    PersonService personService;

    ProductService productService;

    CategoryService categoryService;

    @GetMapping(value = "/createProduct")
    public String createProduct(final Product product, final Model model) {
        getProperties(model);
        return "addProduct";
    }

    /**
     * Ajouter un produit
     *
     * @param model
     * @return
     */
    @PostMapping(value = "/addProduct")
    public String saveProduct(@Valid final Product product, final BindingResult result, final Model model) {
        getProperties(model);
        if (result.hasErrors()) {
            return "addProduct";
        }
        ProductUtils.buildProducts().add(product);
        return REDIRECT + "products";
        //return (result.hasErrors()) ? REDIRECT + "addProduct" : REDIRECT + "products";
    }

    @GetMapping(value = "/edit/{id}")
    public String showUpdateFormProduct(@PathVariable("id") final int id, final Model model) {
        getProperties(model);
           List<Product> products =  ProductUtils.buildProducts();
           for(Product product : products) {
               if(product.getId() == id) {
                   model.addAttribute("product",product);
               }
        }
        return "updateProduct";
    }

    @PostMapping(value = "/update/{id}")
    public String updateProduct(@PathVariable("id") final int id, @Valid final Product product, final BindingResult result, final Model model) {
        getProperties(model);
        if(result.hasErrors()) {
            product.setId(id);
            return "updateProduct";
        }
        ProductUtils.buildProducts().add(product);
        return REDIRECT + "products";
    }

    /**
     * Suppression de produit si l'id correspond à celui d'un produit
     *
     * @param id    identifiant
     * @return la liste produit
     */
    @GetMapping(value = "/delete/{id}")
    public String deleteProduct(@PathVariable("id") final int id, final Model model) {
        getProperties(model);
        List<Product> products = ProductUtils.buildProducts();
     /*   for (Product product : products) {
            if (product.getId() == id) {
               products.remove(product);
               break;
            }
            log.info("Produit " + product.getName() + " supprimé");
        }*/
        products.removeIf(product -> product.getId() == id);


        return REDIRECT + "products";
    }

    /**
     * Recherche
     * @param model
     * @return produit
     */
    @GetMapping(value = "/find/{id}")
    public String findProductByName(@PathVariable("id") final int id, final Model model) {
        getProperties(model);
        Product product = productService.findProductById(id);
        model.addAttribute("productById",product);
        return "findProductPage";
    }

    /**
     * Recherche
     * @param model
     * @return produit
     */
    @GetMapping(value = "/find/{name}")
    public String searchProductByName(@PathVariable("name") final String name, final BindingResult result, final Model model) {
        getProperties(model);
        Product product = productService.findProductByName(name);
        model.addAttribute("productByName",product);
        //return result.hasErrors() ? "searchProductPage": REDIRECT +"productsPage";
        return  "searchProductPage";
    }


    @GetMapping(value = "/")
    public String home(final Model model) {
        getProperties(model);
        return "index";
    }

    //@RequestMapping(value = "/persons", method = RequestMethod.GET)
    @GetMapping("/persons")
    public String getPersonList(Model model,
                                @RequestParam("page") final Optional<Integer> page,
                                @RequestParam("size") final Optional<Integer> size) {
        getProperties(model);
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
        getProperties(model);
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
        getProperties(model);
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