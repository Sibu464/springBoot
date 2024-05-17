package com.shop.store_backend.repository;

import com.shop.store_backend.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    static Optional<Customer> findByEmailAndPassword(String email, String password) {
        return Optional.empty();
    }

    Optional<Customer> findByEmail(String url);
}
