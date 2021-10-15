package com.kodilla.customer.mapper;

import com.kodilla.customer.domain.Customer;
import com.kodilla.customer.dto.CustomerDto;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public CustomerDto mapToCustomerDto(Customer customer) {
        return new CustomerDto(
                customer.getId(),
                customer.getFirstname(),
                customer.getLastname()
        );
    }
}
