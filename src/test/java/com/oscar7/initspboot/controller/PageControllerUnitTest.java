package com.oscar7.initspboot.controller;
import com.oscar7.initspboot.config.ConfigProperties;
import com.oscar7.initspboot.entities.Person;
import com.oscar7.initspboot.services.CategoryService;
import com.oscar7.initspboot.services.PersonService;
import com.oscar7.initspboot.services.ProductService;
import com.oscar7.initspboot.utils.PersonUtils;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.servlet.View;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.Matchers.*;

@RunWith(MockitoJUnitRunner.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PageControllerUnitTest {
    @Mock
    View view;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
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
    Page<Person> personPage;

    @Mock
    RequestBuilder defaultRequestBuilder;


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
    /*      final String urlTemplate = "/persons";
          final String viewPageName = "personsPage.html";
          Pageable pageable = Mockito.mock(Pageable.class);

          Mockito.doReturn(personPage).when(personService).findPersonsPaginated(pageable);
          MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get(urlTemplate))

                  .andExpect(MockMvcResultMatchers.status().isOk())
                  .andExpect(MockMvcResultMatchers.view().name(viewPageName))
                  .andReturn();
          Assert.assertNotNull(result.getModelAndView());
*/
    }

    @Mock
    Page<Person> pagePerson;

    @Mock
    PersonUtils personUtils;

    @Test
    public void return_page_view_person_page_when_getPersonList_is_called() {
       /* // Given
        int pageSize = 5;
        int currentPage = 2;
        Person nicePerson = new Person(1, "Dhalia", "Nice", "dhalia@oscar7pro.com", "14/03/198");
        Person specialPerson = new Person(1, "Dhalia", "Nice", "dhalia@oscar7pro.com", "14/03/198");
        Person greatPerson = new Person(1, "Dhalia", "Nice", "dhalia@oscar7pro.com", "14/03/198");

        Pageable pageable = Mockito.mock(Pageable.class);
        Mockito.doReturn(pageSize).when(pageable).getPageSize();
        Mockito.doReturn(currentPage).when(pageable).getPageNumber();
        List<Person> allperson = Arrays.asList(nicePerson, specialPerson, greatPerson);
        //Mockito.doReturn(allperson).when(personUtils).buildPersons();
        Mockito.doReturn(pagePerson).when(personService).findPersonsPaginated(PageRequest.of(1, 3));
        Mockito.doReturn(5).when(pagePerson).getTotalPages();

        String pageVue = "personPage.html";
        Model model = Mockito.mock(Model.class);

        // When
        String result = controller.getPersonList(model,,Mockito.any());

        // Then
        Assert.assertEquals(pageVue, result);

 */
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
    public void should_return_person_page_when_getPersonList_is_called() {
        // Given
      /*  String viewPage = "personsPage";
        int totalePages = 45;
        Model model = Mockito.mock(Model.class);
        Mockito.doReturn(personPage).when(personService).findPersonsPaginated(PageRequest.of( 1, 5));
        Mockito.doReturn(totalePages).when(personPage).getTotalPages();
        List<Integer> pageNumbers = new ArrayList<>();
        pageNumbers.add(100);
        IntStream.rangeClosed(1, totalePages).boxed().collect(Collectors.toList());
        Mockito.doReturn(pageNumbers).when(IntStream.rangeClosed(1, totalePages));

        Person person = Mockito.mock(Person.class);
*/

        // When

        // Then

    }

}
