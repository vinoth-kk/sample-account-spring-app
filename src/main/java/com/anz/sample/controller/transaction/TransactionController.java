package com.anz.sample.controller.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anz.sample.exceptions.InvalidAccountException;
import com.anz.sample.service.TransactionService;

@RestController
@RequestMapping("/accounts/{accountNo}/transactions")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@GetMapping()
	public ResponseEntity<AccountTransactionsResponse> getTransactions(@PathVariable String accountNo) {
		AccountTransactionsResponse accountTransactions = transactionService.getAllTransactionsForAccount(accountNo);
		if (accountTransactions == null) {
			throw new InvalidAccountException();
		}
		return new ResponseEntity<>(accountTransactions, HttpStatus.OK);
	}

}
