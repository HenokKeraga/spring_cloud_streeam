package edu.miu.mockitodemo.business;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TodoBusinessImplTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testSample() {
        var captor = ArgumentCaptor.forClass(Map.class);
//        Mockito.verify().
        var arg=captor.getValue();
        assertArrayEquals(new String[]{"1"},arg.keySet().toArray(String[]::new) );
    }

    @AfterEach
    void tearDown() {
    }
}
