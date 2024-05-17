package com.shop.store_backend.controller;

import ch.qos.logback.core.model.Model;
import com.shop.store_backend.models.Customer;
import com.shop.store_backend.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/Customers")
    public String listCustomers(Model model) {
        List<Customer> customers = customerService.findAllCustomers();
        return customers.toString();
    }
    //////////////////////////////


    @Autowired
    private CustomerService userService;

    @GetMapping
    public List<Customer> getAllUsers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getUserById(@PathVariable Long id) {
        Customer customer = customerService.getUserById(id);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Customer> createUser(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }

    //    public ResponseEntity<Customer> getUserByEmailAndPassword(@RequestParam String email, @RequestParam String password) {
//        Optional<Customer> customer = CustomerService.findByEmailAndPassword(email, password);
//        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
//    }
    @GetMapping("/login")
    public ResponseEntity<Customer> getUserByEmailAndPassword(@RequestParam String email, @RequestParam String password) {
        Optional<Customer> user = userService.getUserByEmailAndPassword(email, password);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }
}



