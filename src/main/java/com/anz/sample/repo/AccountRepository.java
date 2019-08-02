package com.anz.sample.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anz.sample.repo.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	Account findByAccountNumber(String accountNumber);
}
