package com.example.gatewayservice;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface CustomerWriter {

    @Gateway(requestChannel = "output")
    void write(CustomerMessageModel messageModel);
}
