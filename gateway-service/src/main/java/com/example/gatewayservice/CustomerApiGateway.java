package com.example.gatewayservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

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
    /*@HystrixCommand(fallbackMethod = "getAllCustomersFallback")*/
    public ResponseEntity<Collection<CustomerDTO>> getAllCustomers(){
        Collection<CustomerDTO> customerDTOS = this.reader.findAll().getContent();
        return ResponseEntity.ok(customerDTOS);
    }

    public ResponseEntity<Collection<CustomerDTO>> getAllCustomersFallback(){
        return ResponseEntity.ok(Collections.emptyList());
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody CustomerDTO customerDTO){
        this.writer.write(new CustomerMessageModel(customerDTO.getFirstName(), customerDTO.getLastName()));
        return ResponseEntity.ok().build();
    }
}
