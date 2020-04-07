package com.oscar7.initspboot.controller;


import com.oscar7.initspboot.config.ConfigProperties;
import com.oscar7.initspboot.services.CategoryService;
import com.oscar7.initspboot.services.PersonService;
import com.oscar7.initspboot.services.ProductService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.Model;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = PageController.class)
@SpringBootTest
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PageControllerUnitTest {
    @InjectMocks
    PageController controller;


    @Mock
    ProductService productService;

    @Mock
    PersonService personService;

    @Mock
    CategoryService categoryService;

    @Test
    public void called_home_is_success_() {
        // Given
        String propertiy = "property";
        String pageVue = "index";
        ConfigProperties configProperties = Mockito.mock(ConfigProperties.class);
        Model model = Mockito.mock(Model.class);

        // When
        String result = controller.home(model);

        // Then
        Assert.assertEquals(pageVue, result);


    }

    @Test
    public void called_home_fail() {

    }

    @Test
    public void called_home_is_success_return_status_code_200() {

    }
}
