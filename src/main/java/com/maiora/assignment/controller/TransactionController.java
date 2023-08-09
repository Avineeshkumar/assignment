package com.maiora.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maiora.assignment.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
	
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/monthly")
    public Object getMonthlyTransactions(@RequestParam String month, @RequestParam String year) {
        
        return transactionService.getMonthlyTransactions(month, year);
    }
}

