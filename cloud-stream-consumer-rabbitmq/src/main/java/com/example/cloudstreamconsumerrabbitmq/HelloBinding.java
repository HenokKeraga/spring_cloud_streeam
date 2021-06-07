package com.example.cloudstreamconsumerrabbitmq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface HelloBinding {

    @Input("input")
    SubscribableChannel input();

}
