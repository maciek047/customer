package com.kodilla.customer.domain;

import lombok.*;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "customers")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="firstname")
    private String firstname;

    @Column(name="lastname")
    private String lastname;
}
