package com.oscar7.initspboot.controller;

import com.oscar7.initspboot.config.ConfigProperties;
import com.oscar7.initspboot.entities.Category;
import com.oscar7.initspboot.entities.Person;
import com.oscar7.initspboot.entities.Product;
import com.oscar7.initspboot.services.CategoryService;
import com.oscar7.initspboot.services.PersonService;
import com.oscar7.initspboot.services.ProductService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.servlet.View;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PageControllerUnitTest {
    @Mock
    View view;

    @Before
    public void setUp() {
        // MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).setSingleView(view).build();
    }


    private MockMvc mockMvc;

    @InjectMocks
    PageController controller;


    @Mock
    ProductService productService;

    @Mock
    PersonService personService;

    @Mock
    CategoryService categoryService;

    @Mock
    ConfigProperties configProperties;

    @Mock
    Page<Person> pagePerson;

    @Mock
    Page<Product> pageProduct;

    @Mock
    Page<Category> pageCategories;

    @Test
    public void return_page_view_index_when_home_is_called() throws Exception {
        final String urlTemplate = "/";
        final String viewPageName = "index";
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get(urlTemplate))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name(viewPageName))
                .andReturn();
        Assert.assertNotNull(result.getModelAndView());
    }

    @Test
    public void should_page_view_person_page_when_getPersonList_is_called() throws Exception {
        final String urlTemplate = "/persons";
        final String viewPageName = "personsPage.html";
        Pageable pageable = Mockito.mock(Pageable.class);

        Mockito.doReturn(pagePerson).when(personService).findPersonsPaginated(Mockito.any(Pageable.class));
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get(urlTemplate))

                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name(viewPageName))
                .andReturn();
        Assert.assertNotNull(result.getModelAndView());
    }

    @Test
    public void return_index_when_home_is_called() {
        // Given
        String pageVue = "index";
        Model model = Mockito.mock(Model.class);

        // When
        String result = controller.home(model);

        // Then
        Assert.assertEquals(pageVue, result);
    }

    @Test
    public void called_home_fail_when_return_is_not_index() {
        // Given
        String pageVue = "";
        Model model = Mockito.mock(Model.class);

        // When
        String result = controller.home(model);

        // Then
        Assert.assertNotEquals(pageVue, result);
    }

    @Test
    public void return_view_person_page_when_getPersonList_is_called() {
        // Given
        String pageVue = "personsPage.html";
        Model model = Mockito.mock(Model.class);
        Mockito.doReturn(pagePerson).when(personService).findPersonsPaginated(Mockito.any(Pageable.class));
        Mockito.doReturn(5).when(pagePerson).getTotalPages();

        // When
        String result = controller.getPersonList(model, Optional.empty(), Optional.empty());

        // Then
        Assert.assertEquals(pageVue, result);
    }

    @Test
    public void fail_getPersonList_when_view_page_is_different() {
        // Given
        final String pageVue = "personPage.html";
        Model model = Mockito.mock(Model.class);
        Mockito.doReturn(pagePerson).when(personService).findPersonsPaginated(Mockito.any(Pageable.class));
        Mockito.doReturn(5).when(pagePerson).getTotalPages();

        // When
        String result = controller.getPersonList(model, Optional.empty(), Optional.empty());

        // Then
        Assert.assertNotEquals("Page differente : ", pageVue, result);
    }

    @Test
    public void return_view_product_page_when_getProductList_is_called() {
        // Given
        String pageVue = "productsPage";
        Model model = Mockito.mock(Model.class);
        Mockito.doReturn(pageProduct).when(productService).findProductsPaginated(Mockito.any(Pageable.class));
        Mockito.doReturn(5).when(pageProduct).getTotalPages();

        // When
        String result = controller.getProductList(model, Optional.empty(), Optional.empty());

        // Then
        Assert.assertEquals(pageVue, result);
    }

    @Test
    public void fail_when_view_is_not_product_page() {
        // Given
        String pageVue = "productPage";
        Model model = Mockito.mock(Model.class);
        Mockito.doReturn(pageProduct).when(productService).findProductsPaginated(Mockito.any(Pageable.class));
        Mockito.doReturn(5).when(pageProduct).getTotalPages();

        // When
        String result = controller.getProductList(model, Optional.empty(), Optional.empty());

        // Then
        Assert.assertNotEquals(pageVue, result);
    }

    @Test
    public void should_return_view_categories_page() {
        // Given
        String pageVue = "categoriesPage";
        Model model = Mockito.mock(Model.class);
        Mockito.doReturn(pageCategories).when(categoryService).findCategoriesPage(Mockito.any(Pageable.class));
        Mockito.doReturn(5).when(pageCategories).getTotalPages();

        // When
        String result = controller.getCategoryList(model, Optional.empty(), Optional.empty());

        // Then
        Assert.assertEquals(pageVue, result);
    }

    @Test
    public void fail_when_view_is_not_categories_page() {
        // Given
        String pageVue = "categoryPage";
        Model model = Mockito.mock(Model.class);
        Mockito.doReturn(pageCategories).when(categoryService).findCategoriesPage(Mockito.any(Pageable.class));
        Mockito.doReturn(5).when(pageCategories).getTotalPages();

        // When
        String result = controller.getCategoryList(model, Optional.empty(), Optional.empty());

        // Then
        Assert.assertNotEquals(pageVue, result);
    }


}
