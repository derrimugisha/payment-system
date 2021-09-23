package com.paymentSystem.paymentsystem.repo;

import com.paymentSystem.paymentsystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
    
}
