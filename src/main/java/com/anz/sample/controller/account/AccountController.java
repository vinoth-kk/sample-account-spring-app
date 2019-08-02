package com.anz.sample.controller.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anz.sample.exceptions.InvalidAccountException;
import com.anz.sample.exceptions.NotFoundException;
import com.anz.sample.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping
	public ResponseEntity<List<AccountResponse>> getAccounts() {
		List<AccountResponse> accounts = accountService.getAllAccounts();
		return new ResponseEntity<>(accounts, HttpStatus.OK);
	}

	@GetMapping("/{accountNo}")
	public ResponseEntity<AccountResponse> getAccountByAccountNumber(@PathVariable String accountNo) {
		AccountResponse account = accountService.getAccountByAccountNo(accountNo);
		if (account == null) {
			throw new NotFoundException();
		}
		return new ResponseEntity<>(account, HttpStatus.OK);
	}

}
