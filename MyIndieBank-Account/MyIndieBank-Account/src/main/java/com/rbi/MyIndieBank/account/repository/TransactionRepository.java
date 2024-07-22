package com.rbi.MyIndieBank.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rbi.MyIndieBank.account.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

	//List<Transaction> findByMobileNumber(Long mobileNumber);

	@Query("select b from Transaction b where b.senderAccountNumber=?1 OR b.receiverAccountNumber=?1")
	List<Transaction> findByAccountNumber(long mobileNumber);
	

}
