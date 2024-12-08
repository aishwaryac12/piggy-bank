package com.piggybankproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piggybankproject.entity.Transaction;
import com.piggybankproject.service.ITransactionService;

@RestController
@RequestMapping("/transaction")
@CrossOrigin
public class TransactionController {

	@Autowired
	ITransactionService tranService;
	
	@PostMapping
	public String addTransaction(@RequestBody Transaction t) {
		return tranService.addTransaction(t);
	}
	
	@GetMapping
	public List<Transaction> findAllTransactions(){
		return tranService.findAllTransactions();
	}
	
	@GetMapping("/id/{transactionId}")
	public Transaction findTransactionById(@PathVariable int transactionId){
		return tranService.findTransactionById(transactionId);
	}
	
	@DeleteMapping("/{transactionId}")
	public String deleteTransaction(@PathVariable int transactionId){
		return tranService.deleteTransaction(transactionId);
	}
	
	@PutMapping
	public String updateTransaction(@RequestBody Transaction transaction){
		return tranService.updateTransaction(transaction);
	}
}
