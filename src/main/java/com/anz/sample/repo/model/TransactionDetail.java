package com.anz.sample.repo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import com.anz.sample.repo.model.enums.CurrencyType;
import com.anz.sample.repo.model.enums.TransactionType;

@Entity
public class TransactionDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transId;

	@Column(name = "trans_code", updatable = false, nullable = false, unique = true)
	private UUID transCode;

	@ManyToOne
	@JoinColumn
	private Account account;

	@Column(name = "value_date", nullable = false)
	private LocalDate valueDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "currency", nullable = false)
	private CurrencyType currency;

	@Enumerated(EnumType.STRING)
	@Column(name = "trans_type", nullable = false)
	private TransactionType transType;

	private BigDecimal debitAmount;
	private BigDecimal creditAmount;
	private String transNarrative;

	@PrePersist
	protected void onCreate() {
		setTransCode(java.util.UUID.randomUUID());
	}

	public TransactionDetail() {
		super();
	}

	public TransactionDetail(Account account, LocalDate valueDate, CurrencyType currency, BigDecimal debitAmount,
			BigDecimal creditAmount, TransactionType transType, String transNarrative) {
		super();
		this.account = account;
		this.valueDate = valueDate;
		this.currency = currency;
		this.debitAmount = debitAmount;
		this.creditAmount = creditAmount;
		this.transType = transType;
		this.transNarrative = transNarrative;
	}

	public int getTransId() {
		return transId;
	}

	public void setTransId(int transId) {
		this.transId = transId;
	}

	public UUID getTransCode() {
		return transCode;
	}

	public void setTransCode(UUID transCode) {
		this.transCode = transCode;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public LocalDate getValueDate() {
		return valueDate;
	}

	public void setValueDate(LocalDate valueDate) {
		this.valueDate = valueDate;
	}

	public CurrencyType getCurrency() {
		return currency;
	}

	public void setCurrency(CurrencyType currency) {
		this.currency = currency;
	}

	public BigDecimal getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(BigDecimal debitAmount) {
		this.debitAmount = debitAmount;
	}

	public BigDecimal getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(BigDecimal creditAmount) {
		this.creditAmount = creditAmount;
	}

	public TransactionType getTransType() {
		return transType;
	}

	public void setTransType(TransactionType transType) {
		this.transType = transType;
	}

	public String getTransNarrative() {
		return transNarrative;
	}

	public void setTransNarrative(String transNarrative) {
		this.transNarrative = transNarrative;
	}

}
