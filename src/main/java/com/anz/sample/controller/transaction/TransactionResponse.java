package com.anz.sample.controller.transaction;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.anz.sample.repo.model.enums.CurrencyType;
import com.anz.sample.repo.model.enums.TransactionType;
import com.anz.sample.util.MoneySerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class TransactionResponse {

	@JsonFormat(pattern="MMM, dd, YYYY")
	private LocalDate valueDate;

	private CurrencyType currency;

	private TransactionType transType;

	@JsonSerialize(using = MoneySerializer.class)
	private BigDecimal debitAmount;
	
	@JsonSerialize(using = MoneySerializer.class)
	private BigDecimal creditAmount;
	private String transNarrative;


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

	public TransactionType getTransType() {
		return transType;
	}

	public void setTransType(TransactionType transType) {
		this.transType = transType;
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

	public String getTransNarrative() {
		return transNarrative;
	}

	public void setTransNarrative(String transNarrative) {
		this.transNarrative = transNarrative;
	}

}
