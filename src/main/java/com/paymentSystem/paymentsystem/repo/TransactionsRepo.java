package com.paymentSystem.paymentsystem.repo;

import com.paymentSystem.paymentsystem.models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsRepo extends JpaRepository<Transactions, Long> {

}
