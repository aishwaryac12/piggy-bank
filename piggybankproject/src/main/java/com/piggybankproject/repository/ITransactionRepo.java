package com.piggybankproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piggybankproject.entity.Transaction;

public interface ITransactionRepo extends JpaRepository<Transaction, Integer> {

}
