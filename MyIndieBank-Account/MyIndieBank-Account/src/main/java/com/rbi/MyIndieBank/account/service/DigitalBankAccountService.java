package com.rbi.MyIndieBank.account.service;

import com.rbi.MyIndieBank.account.exception.MyIndieBankGloabalExceptionHandler;

public interface DigitalBankAccountService {

	String linkAccount(Long mobileNumber, Long accountNumber) throws MyIndieBankGloabalExceptionHandler;

	String linkAccount(Long mobileNumber, Long accountNumber, Integer otp)throws MyIndieBankGloabalExceptionHandler;





}
