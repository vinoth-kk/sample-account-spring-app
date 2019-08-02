package com.anz.sample;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.anz.sample.repo.AccountRepository;
import com.anz.sample.repo.TransactionDetailRepository;
import com.anz.sample.repo.model.Account;
import com.anz.sample.repo.model.TransactionDetail;
import com.anz.sample.repo.model.enums.AccountType;
import com.anz.sample.repo.model.enums.CurrencyType;
import com.anz.sample.repo.model.enums.TransactionType;

@Component
public class DataInit implements ApplicationRunner {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private TransactionDetailRepository transactionDetailRepository;

	public DataInit() {

	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		accountRepository.save(new Account("4537152876", "AUSavings726", AccountType.SAVINGS,
				LocalDate.of(2018, Month.NOVEMBER, 8), CurrencyType.AUD, new BigDecimal(84327.39)));

		accountRepository.save(new Account("4537658648", "SGCurrent745", AccountType.CURRENT,
				LocalDate.of(2018, Month.APRIL, 24), CurrencyType.SGD, new BigDecimal(124327.22)));

		accountRepository.save(new Account("4537152465", "SGSavings654", AccountType.SAVINGS,
				LocalDate.of(2018, Month.MARCH, 1), CurrencyType.SGD, new BigDecimal(92327.56)));

		accountRepository.save(new Account("4536778557", "AUSavings476", AccountType.SAVINGS,
				LocalDate.of(2018, Month.JANUARY, 11), CurrencyType.AUD, new BigDecimal(134566.87)));

		// get the accounts
		List<Account> accounts = accountRepository.findAll();
		Account account1 = accounts.get(0);
		transactionDetailRepository.save(new TransactionDetail(account1, LocalDate.of(2018, Month.APRIL, 24),
				CurrencyType.AUD, null, new BigDecimal(134566.87), TransactionType.CREDIT, "erew"));
		transactionDetailRepository.save(new TransactionDetail(account1, LocalDate.of(2018, Month.APRIL, 24),
				CurrencyType.AUD, null, new BigDecimal(134566.87),TransactionType.CREDIT, "erew"));
		transactionDetailRepository.save(new TransactionDetail(account1, LocalDate.of(2018, Month.APRIL, 24),
				CurrencyType.AUD, null, new BigDecimal(134566.87),TransactionType.CREDIT, "erew"));
		transactionDetailRepository.save(new TransactionDetail(account1, LocalDate.of(2018, Month.APRIL, 24),
				CurrencyType.AUD, null, new BigDecimal(134566.87),TransactionType.CREDIT, "erew"));
		transactionDetailRepository.save(new TransactionDetail(account1, LocalDate.of(2018, Month.APRIL, 24),
				CurrencyType.AUD, null, new BigDecimal(134566.87),TransactionType.CREDIT, "erew"));
		
		Account account2 = accounts.get(1);
		transactionDetailRepository.save(new TransactionDetail(account2, LocalDate.of(2018, Month.APRIL, 24),
				CurrencyType.SGD, new BigDecimal(134566.87), null,TransactionType.DEBIT, "erew"));
		transactionDetailRepository.save(new TransactionDetail(account2, LocalDate.of(2018, Month.APRIL, 24),
				CurrencyType.SGD, new BigDecimal(134566.87), null,TransactionType.DEBIT, "erew"));
		transactionDetailRepository.save(new TransactionDetail(account2, LocalDate.of(2018, Month.APRIL, 24),
				CurrencyType.SGD, null, new BigDecimal(134566.87),TransactionType.CREDIT, "erew"));
		transactionDetailRepository.save(new TransactionDetail(account2, LocalDate.of(2018, Month.APRIL, 24),
				CurrencyType.SGD, null, new BigDecimal(134566.87),TransactionType.CREDIT, "erew"));
		transactionDetailRepository.save(new TransactionDetail(account2, LocalDate.of(2018, Month.APRIL, 24),
				CurrencyType.SGD, null, new BigDecimal(134566.87),TransactionType.CREDIT, "erew"));
		
		Account account3 = accounts.get(2);
		transactionDetailRepository.save(new TransactionDetail(account3, LocalDate.of(2018, Month.APRIL, 24),
				CurrencyType.AUD, null, new BigDecimal(134566.87),TransactionType.CREDIT, "erew"));
		transactionDetailRepository.save(new TransactionDetail(account3, LocalDate.of(2018, Month.APRIL, 24),
				CurrencyType.AUD, null, new BigDecimal(134566.87),TransactionType.CREDIT, "erew"));
		transactionDetailRepository.save(new TransactionDetail(account3, LocalDate.of(2018, Month.APRIL, 24),
				CurrencyType.AUD, new BigDecimal(134566.87), null,TransactionType.DEBIT, "erew"));
		transactionDetailRepository.save(new TransactionDetail(account3, LocalDate.of(2018, Month.APRIL, 24),
				CurrencyType.AUD, new BigDecimal(134566.87), null,TransactionType.DEBIT, "erew"));
		transactionDetailRepository.save(new TransactionDetail(account3, LocalDate.of(2018, Month.APRIL, 24),
				CurrencyType.AUD, new BigDecimal(134566.87), null,TransactionType.DEBIT, "erew"));
	}
}
