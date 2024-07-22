package com.rbi.MyIndieBank.account.service;

import java.util.List;

import com.rbi.MyIndieBank.account.dto.AccountDTO;
import com.rbi.MyIndieBank.account.exception.MyIndieBankGloabalExceptionHandler;

public interface AccountService {

	String createAccount(AccountDTO accountDTO);

	List<AccountDTO> listAccounts(Long mobileNumber) throws MyIndieBankGloabalExceptionHandler;

	Double checkBalance(Long mobileNumber, Long accountNumber) throws MyIndieBankGloabalExceptionHandler;


}
