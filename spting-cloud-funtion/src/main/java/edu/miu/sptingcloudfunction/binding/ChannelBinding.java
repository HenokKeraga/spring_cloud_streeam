package edu.miu.sptingcloudfunction.binding;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ChannelBinding {
    @Input("input")
    MessageChannel input();

    @Output("output")
    MessageChannel output();
}
