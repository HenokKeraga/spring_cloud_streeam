package com.example.cloudstreamconsumerrabbitmq;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(HelloBinding.class)
public class HelloListener {

    @StreamListener("input")
    public void input(String msg) {
        System.out.println("::::::::::::::::::"+msg);
    }
}
