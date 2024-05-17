package com.shop.store_backend.services;

import com.shop.store_backend.models.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customer> findAllCustomers();

    Customer createCustomer(Customer customer);

    Customer getUserById(Long id);

    List<Customer> getAllCustomers();
    Optional<Customer> findByEmailAndPassword(String email, String password);

    public Optional<Customer> getUserByEmailAndPassword(String email, String password) ;


}
