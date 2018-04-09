package com.example.gatewayservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/customers")
@RestController
public class CustomerApiGateway {

    private final CustomerWriter writer;

    private final CustomerReader reader;

    public CustomerApiGateway(CustomerWriter writer,
                              CustomerReader reader) {
        this.writer = writer;
        this.reader = reader;
    }

    @GetMapping
    @HystrixCommand(fallbackMethod = "getAllCustomersFallback")
    public ResponseEntity<?> getAllCustomers(){
        List<CustomerDTO> collect = this.reader.findAll()
                .getContent()
                .stream()
                .collect(Collectors.toList());
        return ResponseEntity.ok(collect);
    }

    public ResponseEntity<?> getAllCustomersFallback(){
        return ResponseEntity.ok(Collections.emptyList());
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody CustomerDTO customerDTO){
        this.writer.write(new CustomerMessageModel(customerDTO.getFirstName(), customerDTO.getLastName()));
        return ResponseEntity.ok().build();
    }
}
