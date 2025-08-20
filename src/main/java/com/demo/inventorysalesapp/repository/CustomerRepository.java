package com.demo.inventorysalesapp.repository;

import com.demo.inventorysalesapp.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByFirstNameOrLastNameIgnoreCase(String firstName, String lastName);
}
