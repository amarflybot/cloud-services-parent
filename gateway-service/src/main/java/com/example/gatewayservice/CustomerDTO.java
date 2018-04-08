package com.example.gatewayservice;

import lombok.Data;

/**
 * This is DTO for rest Interfaces
 *
 * @see CustomerMessageModel for Queue based Message DTOs.
 */
@Data
public class CustomerDTO {

    private String firstName;
    private String lastName;

}
