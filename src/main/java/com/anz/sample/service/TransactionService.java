package com.anz.sample.service;

import com.anz.sample.controller.transaction.AccountTransactionsResponse;
import com.anz.sample.exceptions.InvalidAccountException;

public interface TransactionService {

	AccountTransactionsResponse getAllTransactionsForAccount(String accountNo);


}
