package com.maiora.assignment.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maiora.assignment.model.Transactions;

public interface TransactionRepository extends JpaRepository<Transactions, Long> {
    List<Transactions> findByDateBetween(LocalDate startDate, LocalDate endDate);
}