package edu.miu.springcloudproducer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface HelloBinding {

    @Output("output")
    SubscribableChannel output();
}
