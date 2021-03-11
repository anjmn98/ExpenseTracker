package com.springboot.expensetrackerapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.expensetrackerapi.exception.ETBadRequestException;
import com.springboot.expensetrackerapi.exception.ETResourceNotFoundException;
import com.springboot.expensetrackerapi.model.Transaction;
import com.springboot.expensetrackerapi.repository.TransactionRepository;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionalRepository;
	
	@Override
	public List<Transaction> retreiveAllTransactions(Integer userId, Integer categoryId) {
		return transactionalRepository.findAll(userId, categoryId);
	}

	@Override
	public Transaction retreiveTransactionById(Integer userId, Integer categoryId, Integer transactionId)
			throws ETResourceNotFoundException {
		return transactionalRepository.findById(userId, categoryId, transactionId);
	}

	@Override
	public Transaction addTransaction(Integer userId, Integer categoryId, Double amount, String note,
			Long transactionDate) throws ETBadRequestException {
		int transactionId = transactionalRepository.create(userId, categoryId, amount, note, transactionDate);
		return transactionalRepository.findById(userId, categoryId, transactionId);
	}

	@Override
	public void updateTransaction(Integer userId, Integer categoryId, Integer transactionId, Transaction transaction)
			throws ETBadRequestException {
		transactionalRepository.update(userId, categoryId, transactionId, transaction);
	}

	@Override
	public void removeTransaction(Integer userId, Integer categoryId, Integer transactionId)
			throws ETResourceNotFoundException {
		transactionalRepository.removeById(userId, categoryId, transactionId);
	}

}
