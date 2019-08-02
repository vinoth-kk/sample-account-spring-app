package com.anz.sample.service;

import java.util.List;

import com.anz.sample.controller.account.AccountResponse;

public interface AccountService {
	List<AccountResponse> getAllAccounts();

	AccountResponse getAccountByAccountNo(String accountNo);
}
