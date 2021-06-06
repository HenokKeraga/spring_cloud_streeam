package edu.miu.sptingcloudfunction.config;


import edu.miu.sptingcloudfunction.binding.ChannelBinding;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.concurrent.BlockingQueue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
class ProjectConfigTest {
    //test function
    //integration test
    //test binder
    @Autowired
    private ChannelBinding rabbitQueue;
    @Autowired
    MessageCollector messageCollector;

    @SpyBean
    ProjectConfig projectConfig;

    @Test
    void contextLoads() throws InterruptedException {
        rabbitQueue.input().send(MessageBuilder.withPayload("hello").build());

        BlockingQueue<?> outputQueue=messageCollector.forChannel(rabbitQueue.output());
        GenericMessage<?> messageOut=( GenericMessage<?> )outputQueue.take();
        String result=String.valueOf(messageOut.getPayload());

        Mockito.verify(projectConfig,Mockito.times(1)).process();

        Assertions.assertEquals("HELLO",result);

    }
    @Test
    void contextLoads2() throws InterruptedException {
        rabbitQueue.input().send(new GenericMessage<byte[]>("hello".getBytes()));

//        BlockingQueue<?> outputQueue=messageCollector.forChannel(rabbitQueue.output());
//        GenericMessage<?> messageOut=( GenericMessage<?> )outputQueue.take();
//        String result=String.valueOf(messageOut.getPayload());

        Mockito.verify(projectConfig,Mockito.times(1)).process();

        Assertions.assertEquals("HELLO",rabbitQueue.output());

    }


}
