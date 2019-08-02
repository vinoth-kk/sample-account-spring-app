package com.anz.sample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anz.sample.controller.transaction.AccountTransactionsResponse;
import com.anz.sample.controller.transaction.TransactionResponse;
import com.anz.sample.exceptions.InvalidAccountException;
import com.anz.sample.repo.AccountRepository;
import com.anz.sample.repo.TransactionDetailRepository;
import com.anz.sample.repo.model.Account;
import com.anz.sample.repo.model.TransactionDetail;

@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionDetailRepository transactionDetailRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public AccountTransactionsResponse getAllTransactionsForAccount(String accountNo) {
		Account accountRecord = accountRepository.findByAccountNumber(accountNo);
		if (accountRecord == null) {
			return null;
		}
		AccountTransactionsResponse accountTransactions = new AccountTransactionsResponse();
		BeanUtils.copyProperties(accountRecord, accountTransactions);
		List<TransactionDetail> transactionRecords = transactionDetailRepository.findByAccount(accountRecord);
		List<TransactionResponse> transactions = new ArrayList<>();
		TransactionResponse transaction = null;
		for (TransactionDetail transactionRecord : transactionRecords) {
			transaction = new TransactionResponse();
			BeanUtils.copyProperties(transactionRecord, transaction);
			transactions.add(transaction);
		}
		accountTransactions.setTransactions(transactions);
		return accountTransactions;
	}
}
