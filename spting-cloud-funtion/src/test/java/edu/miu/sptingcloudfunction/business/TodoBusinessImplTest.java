package edu.miu.sptingcloudfunction.business;

import edu.miu.sptingcloudfunction.business.api.TodoService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledIfSystemProperties;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.mockito.*;

import java.util.List;

//1. create an instance of the class under test
//2. setup inputs
//3. execute the code you want to test
//4. verify the result is what you expect
class TodoBusinessImplTest {
    @Mock
    TodoService todoService;

    TodoBusinessImpl todoBusiness;
    @Captor
    ArgumentCaptor<String> captor;

    @BeforeEach
    void setUp() {
        // initilize the mock annotaiton
        MockitoAnnotations.openMocks(this);
        todoBusiness = Mockito.spy(new TodoBusinessImpl(todoService));

    }

    @Test
        //stubbing method
        //types => normal syntax when thenReturn
        //types => Alternative syntax doReturn when
        //types => BDD syntax given willReturn
    void retrieveTodosRelatedToSpring() {
        Mockito.when(todoService.retrieveTodos(Mockito.anyString()))
                .thenReturn(
                        List.of("Spring cloud", "Spring cloud stream", "hibernate")
                );
        var result = todoBusiness.retrieveTodosRelatedToSpring("henok");

        // var captor= ArgumentCaptor.forClass(String.class);

        Mockito.verify(todoService).retrieveTodos(captor.capture()); //matcher

        var arg = captor.getValue();

        Assertions.assertEquals("henok", arg);

        Assertions.assertIterableEquals(List.of( "Spring cloud", "Spring cloud stream"), result);

    }

    @Test
    @Disabled
    @Tag("unit_test")
    void testDisabled() {
    }

    @Test
    @EnabledOnOs(OS.MAC)
//    @EnabledIfSystemProperties(value = )
    void deleteTodosNotRelatedToSpring() {
    }


    @AfterEach
    void tearDown() {
    }

}
