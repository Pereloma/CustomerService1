package com.example.robofinance.repository;

import com.example.robofinance.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Customer findFirstByFirstName(String firstName);
    Customer findFirstByLastName(String lastName);
    Customer findFirstById(Long id);

    List<Customer> findByLastNameAndFirstNameAllIgnoreCase(String lastName, String firstName);
    List<Customer> findAllByFirstName (String firstName);
    List<Customer> findAllByLastName (String lastName);
    List<Customer> findAllBySex (String sex);
}
