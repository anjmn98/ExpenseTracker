package com.springboot.expensetrackerapi.service;

import java.util.List;

import com.springboot.expensetrackerapi.exception.ETBadRequestException;
import com.springboot.expensetrackerapi.exception.ETResourceNotFoundException;
import com.springboot.expensetrackerapi.model.Transaction;

public interface TransactionService {
	
	List<Transaction> retreiveAllTransactions(Integer userId, Integer categoryId);
	
	Transaction retreiveTransactionById(Integer userId, Integer categoryId, Integer transactionId) throws ETResourceNotFoundException;
	
	Transaction addTransaction(Integer userId, Integer categoryId, Double amount, String note, Long transactionDate) throws ETBadRequestException;
	
	void updateTransaction(Integer userId, Integer categoryId, Integer transactionId, Transaction transaction) throws ETBadRequestException;
	
	void removeTransaction(Integer userId, Integer categoryId, Integer transactionId) throws ETResourceNotFoundException;
	
	
}
