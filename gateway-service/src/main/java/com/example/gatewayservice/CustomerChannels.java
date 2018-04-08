package com.example.gatewayservice;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CustomerChannels {

    @Output
    MessageChannel output();

}
