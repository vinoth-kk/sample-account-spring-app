package com.anz.sample.controller.account;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.anz.sample.repo.model.enums.AccountType;
import com.anz.sample.repo.model.enums.CurrencyType;
import com.anz.sample.util.MoneySerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class AccountResponse {

	private String accountNumber;
	private String accountName;
	private AccountType accountType;
	
	@JsonFormat(pattern="dd/MM/YYYY")
	private LocalDate balanceDate;
	
	private CurrencyType currency;
	
	@JsonSerialize(using = MoneySerializer.class)
	private BigDecimal openingAvailableBalance;

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

	public LocalDate getBalanceDate() {
		return balanceDate;
	}

	public void setBalanceDate(LocalDate balanceDate) {
		this.balanceDate = balanceDate;
	}

	public CurrencyType getCurrency() {
		return currency;
	}

	public void setCurrency(CurrencyType currency) {
		this.currency = currency;
	}

	public BigDecimal getOpeningAvailableBalance() {
		return openingAvailableBalance;
	}

	public void setOpeningAvailableBalance(BigDecimal openingAvailableBalance) {
		this.openingAvailableBalance = openingAvailableBalance;
	}

}
