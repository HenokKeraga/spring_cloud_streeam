package edu.miu.mockitodemo.helper;

import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

class StringHelperTest {
    @Mock
    StringProviderInterface stringProviderInterface;

    StringHelper stringHelper;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        stringHelper = Mockito.spy(new StringHelper(stringProviderInterface));

    }


    @ParameterizedTest
    @ValueSource(strings = {"ACD","AACD","CD"})
    public void stringHelper_shouldTrancateAFromFirst_2_Positions(String v) {
        when(stringProviderInterface.getName()).thenReturn(createString(str -> {
            str.append(v);
        }));

        String result = stringHelper.truncateAInFirst2Positions();

        Mockito.verify(stringProviderInterface, times(1)).getName();
        Assertions.assertTrue("CD".equals(result));

    }




    String createString(Consumer<StringBuilder> consumer) {
        var data = new StringBuilder();
        if (consumer != null) {
            consumer.accept(data);
        }
        return data.toString();
    }
}
