package com.rbi.MyIndieBank.account.service;

import java.util.List;

import com.rbi.MyIndieBank.account.dto.TransactionDTO;
import com.rbi.MyIndieBank.account.exception.MyIndieBankGloabalExceptionHandler;

public interface TransactionService {

	String fundTransfer(TransactionDTO transactionDTO) throws MyIndieBankGloabalExceptionHandler;

	List<TransactionDTO> accountStatement(Long mobileNumber) throws MyIndieBankGloabalExceptionHandler;

}
