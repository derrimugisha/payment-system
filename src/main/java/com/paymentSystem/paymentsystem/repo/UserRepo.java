package com.paymentSystem.paymentsystem.repo;

import com.paymentSystem.paymentsystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    
}
