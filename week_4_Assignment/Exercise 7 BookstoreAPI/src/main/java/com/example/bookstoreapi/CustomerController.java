package com.example.bookstoreapi;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private List<Customer> customers = new ArrayList<>();

    // POST a new customer (JSON request body)
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        customer.setId((long) (customers.size() + 1));  // Simple ID assignment
        customers.add(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    // POST form data for customer registration
    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomer(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password) {

        Customer customer = new Customer();
        customer.setId((long) (customers.size() + 1));  // Simple ID assignment
        customer.setName(name);
        customer.setEmail(email);
        customer.setPassword(password);

        customers.add(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    // GET all customers (for testing purposes)
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}

