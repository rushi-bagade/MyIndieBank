package com.rbi.MyIndieBank.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rbi.MyIndieBank.account.entity.DigitalBankAccount;

public interface DigitalBankAccountRepository extends JpaRepository<DigitalBankAccount, String>{


	DigitalBankAccount findByAccountNumber(Long accountNumber);

	DigitalBankAccount findByMobileNumber(Long mobileNumber);


}
