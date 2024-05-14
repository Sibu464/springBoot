package com.shop.store_backend.controller;

import ch.qos.logback.core.model.Model;
import com.shop.store_backend.models.Customer;
import com.shop.store_backend.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerController {
    private CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }

    @GetMapping("/Customers")
    public String listCustomers(Model model){
        List<Customer> customers =customerService.findAllCustomers();
        return customers.toString();
    }


}
