package com.demo.inventorysalesapp.rest;

import com.demo.inventorysalesapp.domain.Customer;
import com.demo.inventorysalesapp.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class CustomerResource {
    private final CustomerRepository customerRepository;

    public CustomerResource(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/api/customers")
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/api/customers{id}")
    public Optional<Customer> getCustomer(@PathVariable Long id) {
        return customerRepository.findById(id);
    }

    @GetMapping("/api/customers/search")
    public List<Customer> searchCustomer(@RequestParam("query") String query) {
        return customerRepository.findByFirstNameOrLastNameIgnoreCase(query, query);
    }

    @PostMapping("/api/customers")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @PutMapping("/api/customer{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        Optional<Customer> optCustomer = customerRepository.findById(id);
        if (optCustomer.isPresent()) {
            return customerRepository.save(customer);
        } else {
            return null;
        }
    }

    @DeleteMapping("/api/customer{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerRepository.deleteById(id);
    }

}
