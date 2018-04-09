package com.example.gatewayservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient("customer-service")
public interface CustomerReader {

    @GetMapping("/customers")
    Resources<CustomerDTO> findAll();

    @GetMapping("/customers/{id}")
    Resources<CustomerDTO> findById(@PathVariable("id") Long id);

    @GetMapping("/customers/search/findByFirstName")
    Resources<CustomerDTO> findByFirstName(@RequestParam("name") String name);

    @GetMapping("/customers/search/findByLastName")
    Resources<CustomerDTO> findByLastName(@RequestParam("name") String name);
}
