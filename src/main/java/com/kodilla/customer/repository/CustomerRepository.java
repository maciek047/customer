package com.kodilla.customer.repository;

import com.kodilla.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findCustomerById(long id);
    Customer save(Customer customer);
}
