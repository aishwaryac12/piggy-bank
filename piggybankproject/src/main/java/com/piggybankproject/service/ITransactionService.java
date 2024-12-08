package com.piggybankproject.service;

import java.util.List;

import com.piggybankproject.entity.Transaction;

public interface ITransactionService {

	public String addTransaction(Transaction t);
	public List<Transaction> findAllTransactions();
	public Transaction findTransactionById(int transactionId);
	public String deleteTransaction(int transactionId);
	public String updateTransaction(Transaction transaction);
	
}
