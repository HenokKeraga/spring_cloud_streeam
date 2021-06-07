package edu.miu.springcloudproducer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableBinding(HelloBinding.class)
public class ProducerController {

    private MessageChannel output;

    public ProducerController( HelloBinding binding) {
        output = binding.output();
    }

    @GetMapping("/greet")
    public void publish() {

        Message<String> msg = MessageBuilder.withPayload("name")
                .build();
        this.output.send(msg);
    }
}
