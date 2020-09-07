package com.mgiovenco.breweryservice.web.controller;


// tells JUnit to run using Spring’s testing support.
// SpringRunner is the new name for SpringJUnit4ClassRunner, it’s just a bit easier on the eye.

//To test the Spring MVC slice of your application you can use the @WebMvcTest annotation. This will:
//Auto-configure Spring MVC, Jackson, Gson, Message converters etc.
//Load relevant components (@Controller, @RestController, @JsonComponent etc)
//Configure MockMVC
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mgiovenco.breweryservice.service.BeerService;
import com.mgiovenco.breweryservice.web.model.BeerDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(BeerController.class)
public class BeerControllerTest {

    /**
     * Mockito.mock()
     *
     * The Mockito.mock() method allows us to create a mock object of a class or an interface.
     * Then, we can use the mock to stub return values for its methods and verify if they were called.
     * This method doesn't need anything else to be done before it can be used. We can use it to create mock class fields as well as local mocks in a method.
     *
     * Example:
     *
     * @Test
     * public void givenCountMethodMocked_WhenCountInvoked_ThenMockedValueReturned() {
     *  UserRepository localMockRepository = Mockito.mock(UserRepository.class);
     *  Mockito.when(localMockRepository.count()).thenReturn(111L);
     *  long userCount = localMockRepository.count();
     *  Assert.assertEquals(111L, userCount);
     *  Mockito.verify(localMockRepository).count();
     * }
     */


    /**
     * @Mock
     *
     * This annotation is a shorthand for the Mockito.mock() method.
     * As well, we should only use it in a test class. Unlike the mock() method, we need to enable Mockito annotations to use this annotation.
     * We can do this either by using the MockitoJUnitRunner to run the test or calling the MockitoAnnotations.initMocks() method explicitly.
     *
     * Example:
     *
     * @RunWith(MockitoJUnitRunner.class)
     * public class MockAnnotationUnitTest {
     *
     * @Mock
     * UserRepository mockRepository;
     *
     * @Test
     * public void givenCountMethodMocked_WhenCountInvoked_ThenMockValueReturned() {
     *  Mockito.when(mockRepository.count()).thenReturn(123L);
     *  long userCount = mockRepository.count();
     *  Assert.assertEquals(123L, userCount);
     *  Mockito.verify(mockRepository).count();
     *}
     *
     * Apart from making the code more readable,
     * @Mock makes it easier to find the problem mock in case of a failure, as the name of the field appears in the failure message.
     * Also, when used in conjunction with @InjectMocks, it can reduce the amount of setup code significantly.
     */


    /**
     * @MockBean
     *
     * We can use the @MockBean to add mock objects to the Spring application context.
     * The mock will replace any existing bean of the same type in the application context.
     * If no bean of the same type is defined, a new one will be added.
     * This annotation is useful in integration tests where a particular bean – for example, an external service – needs to be mocked.
     * <p>
     * Example:
     * @RunWith(SpringRunner.class)
     * public class MockBeanAnnotationIntegrationTest {
     *
     *  @MockBean UserRepository mockRepository;
     *
     *  @Autowired ApplicationContext context;
     *
     *  @Test
     *  public void givenCountMethodMocked_WhenCountInvoked_ThenMockValueReturned() {
     *      Mockito.when(mockRepository.count()).thenReturn(123L);
     *      UserRepository userRepoFromContext = context.getBean(UserRepository.class);
     *      long userCount = userRepoFromContext.count();
     *      Assert.assertEquals(123L, userCount);
     *      Mockito.verify(mockRepository).count();
     *  }
     * }
     */

    @MockBean
    BeerService beerService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    BeerDto validBeer;

    @Before
    public void setUp() throws Exception {
       validBeer = BeerDto.builder()
               .id(UUID.randomUUID())
               .beerStyle("PALE_ALE")
               .upc(123456789012L)
               .build();
    }

    @Test
    public void getBeer() throws Exception {
        given(beerService.getBeerById(any(UUID.class))).willReturn(validBeer);

        mockMvc.perform(get("/api/v1/beer/" + validBeer.getId().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
                //.andExpect(content().contentType(MediaType.APPLICATION_JSON))
                //.andExpect(jsonPath("$.beerName"), is("Beer1"));
    }
}