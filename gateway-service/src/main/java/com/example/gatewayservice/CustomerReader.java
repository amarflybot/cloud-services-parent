package com.example.gatewayservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@FeignClient("customer-service")
public interface CustomerReader {

    @GetMapping("/customers")
    Resource<Collection<CustomerDTO>> findAll();

    @GetMapping("/customers/{id}")
    Resource<CustomerDTO> findById(@PathVariable("id") Long id);

    @GetMapping("/customers/search/findByFirstName")
    Resource<CustomerDTO> findByFirstName(@RequestParam("name") String name);

    @GetMapping("/customers/search/findByLastName")
    Resource<CustomerDTO> findByLastName(@RequestParam("name") String name);
}
