package com.anz.sample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anz.sample.controller.account.AccountResponse;
import com.anz.sample.repo.AccountRepository;
import com.anz.sample.repo.model.Account;

@Service("userService")
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public List<AccountResponse> getAllAccounts() {
		List<Account> accountRecords = accountRepository.findAll();
		if (accountRecords == null || accountRecords.isEmpty()) {
			return null;
		}
		List<AccountResponse> accountList = new ArrayList<>(accountRecords.size());
		AccountResponse account = null;
		for (Account accountRecord : accountRecords) {
			account = new AccountResponse();
			BeanUtils.copyProperties(accountRecord, account);
			accountList.add(account);
		}
		return accountList;

	}

	@Override
	public AccountResponse getAccountByAccountNo(String accountNo) {
		Account accountRecord = accountRepository.findByAccountNumber(accountNo);
		if (accountRecord == null) {
			return null;
		}
		AccountResponse account = new AccountResponse();
		BeanUtils.copyProperties(accountRecord, account);
		return account;

	}

}
