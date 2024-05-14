package com.shop.store_backend.services.impl;

import com.shop.store_backend.models.Customer;
import com.shop.store_backend.repository.CustomerRepository;
import com.shop.store_backend.services.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
@Override
    public List<Customer> findAllCustomers(){
        List<Customer> Customers=customerRepository.findAll();
        return Customers;
}


}
