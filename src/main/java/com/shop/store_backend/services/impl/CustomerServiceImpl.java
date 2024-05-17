package com.shop.store_backend.services.impl;

import com.shop.store_backend.models.Customer;
import com.shop.store_backend.repository.CustomerRepository;
import com.shop.store_backend.services.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Customer createCustomer(Customer customer) {
        return null;
    }

    @Override
    public Customer getUserById(Long id) {
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return List.of();
    }

    @Override
    public Optional<Customer> findByEmailAndPassword(String email, String password) {
        return CustomerRepository.findByEmailAndPassword(email, password);
    }

    @Override

    public Optional<Customer> getUserByEmailAndPassword(String email, String password) {
        return CustomerRepository.findByEmailAndPassword(email, password);
    }


}
