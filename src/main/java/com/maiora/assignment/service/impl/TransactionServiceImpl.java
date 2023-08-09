package com.maiora.assignment.service.impl;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maiora.assignment.repository.TransactionRepository;
import com.maiora.assignment.service.TransactionService;

import com.maiora.assignment.model.Transactions;

@Service
public class TransactionServiceImpl implements TransactionService  {
    
	@Autowired
    private TransactionRepository transactionRepository;

	@Override
    public List<Transactions> getMonthlyTransactions(String month, String year) {
		
		LocalDate startDate = LocalDate.of(Integer.parseInt(year), Month.valueOf(month.toUpperCase()), 1);
        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());
        return transactionRepository.findByDateBetween(startDate, endDate);
    }
}
