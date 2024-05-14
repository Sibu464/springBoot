package com.shop.store_backend.services;

import com.shop.store_backend.models.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAllCustomers();
}
