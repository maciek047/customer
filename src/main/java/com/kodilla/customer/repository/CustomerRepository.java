package com.kodilla.customer.repository;

import com.kodilla.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    public Customer findCustomerById(int id);
    Customer save(Customer customer);
}
