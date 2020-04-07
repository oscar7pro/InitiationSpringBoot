package com.oscar7.initspboot.controller;


import com.oscar7.initspboot.config.ConfigProperties;
import com.oscar7.initspboot.entities.Person;
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
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RunWith(MockitoJUnitRunner.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PageControllerUnitTest {

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
    MockMvc mockMvc;

    @InjectMocks
    PageController controller;


    @Mock
    ProductService productService;

    @Mock
    PersonService personService;

    @Mock
    CategoryService categoryService;

    @Mock
    ConfigProperties configProperties ;

    @Mock
    Page<Person> personPage;


    @Test
    public void return_index_when_home() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("index"))
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
        String pageVue = "";
        Model model = Mockito.mock(Model.class);

        // When
        String result = controller.home(model);

        // Then
        Assert.assertNotEquals(pageVue, result);
    }

    @Test
    public void should_return_person_page_when_getPersonList_is_called () {
        // Given

        Optional<Integer> page = Mockito.mock(Optional.class);
        Optional<Integer> size = Mockito.mock(Optional.class);
                ;

        // @Mock

        String viewPage = "personsPage";
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(3);
        int totalePages = 45;
        PageRequest pageRequest = PageRequest.of(currentPage - 1, pageSize);
        Model model = Mockito.mock(Model.class);
        Mockito.doReturn(personPage).when(personService).findPersonsPaginated(pageRequest);
        Mockito.doReturn(totalePages).when(personPage).getTotalPages();
        List<Integer> pageNumbers = new ArrayList<>();
        pageNumbers.add(100);
        IntStream.rangeClosed(1, totalePages).boxed().collect(Collectors.toList());
        Mockito.doReturn(pageNumbers).when(IntStream.rangeClosed(1, totalePages));

        Person person = Mockito.mock(Person.class);


        // When
        String result = controller.getPersonList(model, page,size);

        // Then
        Assert.assertEquals(viewPage,result);

    }

}
