package edu.miu.sptingcloudfunction.business;

import edu.miu.sptingcloudfunction.business.api.TodoService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.List;

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

        var arg=captor.getValue();
        Assertions.assertEquals("henok",arg);

        Assertions.assertArrayEquals(List.of(
                "Spring cloud", "Spring cloud stream").toArray(String[]::new),
                result.toArray(String[]::new)
        );
    }

    @Test
    void deleteTodosNotRelatedToSpring() {
    }


    @AfterEach
    void tearDown() {
    }

}
