package edu.miu.sptingcloudfuntion;

import edu.miu.sptingcloudfunction.business.TodoBusinessImpl;
import edu.miu.sptingcloudfunction.business.api.TodoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class SptingCloudFuntionApplicationTests {
    @Mock
    TodoService todoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void contextLoads() {
        var todoBusiness = new TodoBusinessImpl(todoService);
        int result = todoBusiness.toTest();
        Assertions.assertEquals(4,result);
    }


}
