package com.springboot.expensetrackerapi.repository;

import java.util.List;

import com.springboot.expensetrackerapi.exception.ETBadRequestException;
import com.springboot.expensetrackerapi.exception.ETResourceNotFoundException;
import com.springboot.expensetrackerapi.model.Transaction;

public interface TransactionRepository {
	
	List<Transaction> findAll(Integer userId, Integer categoryId);
	
	Transaction findById(Integer userId, Integer categoryId, Integer transactionId) throws ETResourceNotFoundException;
	
	Integer create(Integer userId, Integer categoryId, Double amount, String note, Long transactionDate) throws ETBadRequestException;
	
	void update(Integer userId, Integer categoryId, Integer transactionId, Transaction transaction) throws ETBadRequestException;
	
	void removeById(Integer userId, Integer categoryId, Integer transactionId) throws ETResourceNotFoundException;
}
