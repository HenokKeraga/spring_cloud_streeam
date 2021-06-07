package com.example.cloudstreamproducerrabbitmq;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(HelloBinding.class)
@SpringBootApplication
public class CloudStreamProducerRabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudStreamProducerRabbitmqApplication.class, args);
    }

}
