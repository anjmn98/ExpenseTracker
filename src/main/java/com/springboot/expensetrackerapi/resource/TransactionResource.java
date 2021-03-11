package com.springboot.expensetrackerapi.resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.expensetrackerapi.model.Transaction;
import com.springboot.expensetrackerapi.service.TransactionService;

@RestController
@RequestMapping("/api/categories/{categoryId}/transactions")
public class TransactionResource {
	
	@Autowired
	TransactionService transactionService;
	
	@PostMapping("")
	public ResponseEntity<Transaction> addTransaction(HttpServletRequest request, @PathVariable Integer categoryId, @RequestBody Map<String, Object> transactionMap) {
		int userId = (Integer) request.getAttribute("userId");
		Double amount = Double.valueOf(transactionMap.get("amount").toString());
		String note = (String) transactionMap.get("note");
		Long transactionDate = (Long) transactionMap.get("transactionDate");
		Transaction transaction = transactionService.addTransaction(userId, categoryId, amount, note, transactionDate);
		return new ResponseEntity<Transaction>(transaction, HttpStatus.CREATED);
	}
	
	@GetMapping("/{transactionId}")
	public ResponseEntity<Transaction> getTransactionById(HttpServletRequest request, @PathVariable Integer categoryId, @PathVariable Integer transactionId) {
		int userId = (Integer) request.getAttribute("userId");
		Transaction transaction = transactionService.retreiveTransactionById(userId, categoryId, transactionId);
		return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
	}
	
	@GetMapping("")
	public ResponseEntity<List<Transaction>> getAllTransactions(HttpServletRequest request, @PathVariable Integer categoryId) {
		int userId = (Integer) request.getAttribute("userId");
		List<Transaction> transactions = transactionService.retreiveAllTransactions(userId, categoryId);
		return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
	}
	
	@PutMapping("/{transactionId}")
	public ResponseEntity<Map<String, Boolean>> updateTransaction(HttpServletRequest request, @PathVariable Integer categoryId, @PathVariable Integer transactionId, @RequestBody Transaction transaction) {
		int userId = (Integer) request.getAttribute("userId");
		transactionService.updateTransaction(userId, categoryId, transactionId, transaction);
		Map<String, Boolean>  map = new HashMap<String, Boolean>();
		map.put("success", true);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	@DeleteMapping("/{transactionId}")
	public ResponseEntity<Map<String, Boolean>> deleteTransaction(HttpServletRequest request, @PathVariable Integer categoryId, @PathVariable Integer transactionId){
		int userId = (Integer) request.getAttribute("userId");
		transactionService.removeTransaction(userId, categoryId, transactionId);
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("success", true);
		return new ResponseEntity<Map<String,Boolean>>(map, HttpStatus.OK);
	}
	
}
