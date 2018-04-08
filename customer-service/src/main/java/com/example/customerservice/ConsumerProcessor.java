package com.example.customerservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.messaging.Message;

@MessageEndpoint
public class ConsumerProcessor {

    private final CustomerRepo repo;

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerProcessor.class);

    public ConsumerProcessor(CustomerRepo repo) {
        this.repo = repo;
    }

    @StreamListener(Sink.INPUT)
    public void process(Message<CustomerMessageModel> message) {
        LOGGER.info("Message Received "+ message);
        CustomerMessageModel customerMessageModel = message.getPayload();
        Customer customer = this.repo.save(new Customer(customerMessageModel.getFirstName(), customerMessageModel.getLastName()));
        LOGGER.info("Saved Customer "+ customer);
    }
}
