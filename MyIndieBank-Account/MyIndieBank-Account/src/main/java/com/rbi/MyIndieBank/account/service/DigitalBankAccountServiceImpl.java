package com.rbi.MyIndieBank.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rbi.MyIndieBank.account.entity.BankAccount;
import com.rbi.MyIndieBank.account.entity.DigitalBankAccount;
import com.rbi.MyIndieBank.account.exception.MyIndieBankGloabalExceptionHandler;
import com.rbi.MyIndieBank.account.repository.AccountRepository;
import com.rbi.MyIndieBank.account.repository.DigitalBankAccountRepository;
import com.rbi.MyIndieBank.account.utility.OTPUtility;

@Service
public class DigitalBankAccountServiceImpl implements DigitalBankAccountService {

	@Autowired
	DigitalBankAccountRepository digitalBankAccountRepository;
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	OTPUtility oTPUtility;

	@Override
	public String linkAccount(Long mobileNumber, Long accountNumber) throws MyIndieBankGloabalExceptionHandler {

		BankAccount accountEntity = accountRepository.findByMobileNumberAndAccountNumber(mobileNumber, accountNumber);
		DigitalBankAccount dba = digitalBankAccountRepository.findByAccountNumber(accountNumber);

		if (accountEntity != null) {

			if (dba == null) {
				DigitalBankAccount obj = new DigitalBankAccount();
				obj.setAccountNumber(accountEntity.getAccountNumber());
				obj.setAccountType(accountEntity.getAccountType());
				obj.setMobileNumber(accountEntity.getMobileNumber());

				obj = digitalBankAccountRepository.save(obj);
				return "Account linked successfully..! Your Digital Banking Id is : " + obj.getDigitalBankingId();
			} else {
				throw new MyIndieBankGloabalExceptionHandler("ACCOUNT_IS_ALREADY_LINKED");
			}
		} else {
			throw new MyIndieBankGloabalExceptionHandler("NO_ACCOUNT_FOUND");
		}
	}

	@Override
	public String linkAccount(Long mobileNumber, Long accountNumber, Integer otp)
			throws MyIndieBankGloabalExceptionHandler {

		BankAccount accountEntity = accountRepository.findByMobileNumberAndAccountNumber(mobileNumber, accountNumber);
		DigitalBankAccount dba = digitalBankAccountRepository.findByAccountNumber(accountNumber);

		Integer otp1 = oTPUtility.sendOTP();
		if (accountEntity != null) {
			if(dba==null) {
				if(otp.equals(otp1)) {
					DigitalBankAccount obj = new DigitalBankAccount();
					obj.setAccountNumber(accountEntity.getAccountNumber());
					obj.setAccountType(accountEntity.getAccountType());
					obj.setMobileNumber(accountEntity.getMobileNumber());

					obj = digitalBankAccountRepository.save(obj);
					return "Account linked successfully..! Your Digital Banking Id is : " + obj.getDigitalBankingId();	
				}	
				else {
					throw new MyIndieBankGloabalExceptionHandler("OTP_DOES_NOT_MATCH");
				}
			}
				 else {
				throw new MyIndieBankGloabalExceptionHandler("ACCOUNT_IS_ALREADY_LINKED");
				}					
		
			
		}
		else {
		throw new MyIndieBankGloabalExceptionHandler("NO_ACCOUNT_FOUND");
		}
	}

	
}
