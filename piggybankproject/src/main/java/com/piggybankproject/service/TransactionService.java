package com.piggybankproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.piggybankproject.entity.Transaction;
import com.piggybankproject.repository.ITransactionRepo;

@Service
public class TransactionService implements ITransactionService{

	@Autowired
	ITransactionRepo tranRepo;
	
	public String addTransaction(Transaction t) {
		tranRepo.save(t);
		return "Added successfully";
	}
	
	public List<Transaction> findAllTransactions(){
		return tranRepo.findAll(Sort.by(Sort.Direction.ASC, "transactionId"));
	}
	
	public Transaction findTransactionById(int transactionId) {
		return tranRepo.findById(transactionId).get();
	}
	
	public String deleteTransaction(int transactionId) {
		Transaction t=findTransactionById(transactionId);
		tranRepo.delete(t);
		return "Deleted successfully";
	}
	
	public String updateTransaction(Transaction transaction) {
		Transaction newTransaction=findTransactionById(transaction.getTransactionId());
		newTransaction.setAmount(transaction.getAmount());
		newTransaction.setType(transaction.getType());
		newTransaction.setDescription(transaction.getDescription());
		newTransaction.setTransactionDate(transaction.getTransactionDate());
		tranRepo.save(newTransaction);
		return "Updated successfully";
	}
}
