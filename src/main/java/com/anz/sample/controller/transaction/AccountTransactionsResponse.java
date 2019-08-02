package com.anz.sample.controller.transaction;

import java.util.List;

import com.anz.sample.repo.model.enums.AccountType;

public class AccountTransactionsResponse {
	private String accountNumber;
	private String accountName;
	private AccountType accountType;
	private List<TransactionResponse> transactions;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public List<TransactionResponse> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<TransactionResponse> transactions) {
		this.transactions = transactions;
	}

}
