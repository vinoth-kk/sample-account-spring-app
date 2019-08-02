package com.anz.sample.repo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.anz.sample.repo.model.enums.AccountType;
import com.anz.sample.repo.model.enums.CurrencyType;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountId;
	
	@Column(name = "account_code",updatable = false,nullable = false, unique = true)
	private UUID accountCode;

	@Column(name = "account_number", length = 20, nullable = false, unique = true)
	private String accountNumber;

	@Column(name = "account_name", length = 250, nullable = false)
	private String accountName;

	@Enumerated(EnumType.STRING)
	@Column(name = "account_type", nullable = false)
	private AccountType accountType;

	@Column(name = "balance_date", nullable = false)
	private LocalDate balanceDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "currency", nullable = false)
	private CurrencyType currency;

	@Column(name = "opening_available_balance", nullable = false)
	private BigDecimal openingAvailableBalance;

	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private Set<TransactionDetail> transactions;
	
	@PrePersist
	protected void onCreate() {
		setAccountCode(java.util.UUID.randomUUID());
	}

	public Account() {
		super();
	}

	public Account(String accountNumber, String accountName, AccountType accountType, LocalDate balanceDate,
			CurrencyType currency, BigDecimal openingAvailableBalance) {
		super();
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.accountType = accountType;
		this.balanceDate = balanceDate;
		this.currency = currency;
		this.openingAvailableBalance = openingAvailableBalance;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public UUID getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(UUID accountCode) {
		this.accountCode = accountCode;
	}

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

	public Set<TransactionDetail> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<TransactionDetail> transactions) {
		this.transactions = transactions;
	}

}
