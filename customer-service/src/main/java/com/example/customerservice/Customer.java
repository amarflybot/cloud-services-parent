package com.example.customerservice;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull private String firstName;

    @NonNull private String lastName;
}
