package com.anz.sample.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.anz.sample.repo.model.Account;
import com.anz.sample.repo.model.TransactionDetail;

public interface TransactionDetailRepository extends JpaRepository<TransactionDetail, Integer> {
	List<TransactionDetail> findByAccount(Account account);
}
