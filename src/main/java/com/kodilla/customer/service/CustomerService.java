package com.kodilla.customer.service;

import com.kodilla.customer.domain.Customer;
import com.kodilla.customer.dto.CustomerDto;
import com.kodilla.customer.mapper.CustomerMapper;
import com.kodilla.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Transactional
    public CustomerDto fetchCustomerById(int customerId) {

        customerRepository.save(new Customer(1,"firts","last"));
        System.out.println("c created");
        return customerMapper.mapToCustomerDto(customerRepository.findCustomerById(customerId));
    }
}
