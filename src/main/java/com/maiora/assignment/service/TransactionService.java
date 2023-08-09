package com.maiora.assignment.service;

import java.util.List;

import com.maiora.assignment.model.Transactions;

public interface TransactionService {

	 List<Transactions> getMonthlyTransactions(String startDate, String endDate);
}
