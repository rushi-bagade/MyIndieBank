package com.rbi.MyIndieBank.account.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rbi.MyIndieBank.account.entity.BankAccount;
import com.rbi.MyIndieBank.account.entity.DigitalBankAccount;

public interface AccountRepository extends JpaRepository<BankAccount, Long>{

	BankAccount findByMobileNumberAndAccountNumber(Long mobileNumber, Long accountNumber);
	
	List<BankAccount> findByMobileNumber(long mobileNumber);
	//BankAccount findByMobileNumber1(long mobileNumber);

	BankAccount findByAccountNumber(Long accountNumber);
	

}
