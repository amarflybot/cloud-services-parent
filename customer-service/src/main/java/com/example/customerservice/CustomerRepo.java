package com.example.customerservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CustomerRepo extends JpaRepository<Customer, Long>{

    Customer findByFirstName(@Param("name") String name);

    Customer findByLastName(@Param("name") String name);

}
