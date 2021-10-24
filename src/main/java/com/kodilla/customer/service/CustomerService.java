package com.kodilla.customer.service;

import com.kodilla.customer.domain.Customer;
import com.kodilla.customer.dto.CustomerDto;
import com.kodilla.customer.mapper.CustomerMapper;
import com.kodilla.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Transactional
    public Optional<CustomerDto> fetchCustomerById(long customerId) {

        customerRepository.save(new Customer(1L,"first","last"));
        System.out.println("c created");
        var customerDto = customerMapper.mapToCustomerDto(customerRepository.findCustomerById(customerId));
        return Optional.of(customerDto);
    }
}
