package com.rbi.MyIndieBank.account.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rbi.MyIndieBank.account.dto.AccountDTO;
import com.rbi.MyIndieBank.account.entity.BankAccount;
import com.rbi.MyIndieBank.account.entity.DigitalBankAccount;
import com.rbi.MyIndieBank.account.exception.MyIndieBankGloabalExceptionHandler;
import com.rbi.MyIndieBank.account.repository.AccountRepository;
import com.rbi.MyIndieBank.account.repository.DigitalBankAccountRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	DigitalBankAccountRepository digitalBankAccountRepository;
	@Autowired
	private ModelMapper modelMapper;

	// Convert Dto to entity
	public BankAccount convertToEntity(AccountDTO accountDTO) {
		return modelMapper.map(accountDTO, BankAccount.class);
	}

	// Convert entity to dto
	public AccountDTO convertToDto(BankAccount list) {
		return modelMapper.map(list, AccountDTO.class);
	}

	@Override
	public String createAccount(AccountDTO accountDTO) {

		BankAccount a = convertToEntity(accountDTO);
		a = accountRepository.save(a);
		System.out.println(a.toString());
		String output = "Account created successfully..!" + a.getAccountNumber();
		return output;
	}

	@Override
	public List<AccountDTO> listAccounts(Long mobileNumber) throws MyIndieBankGloabalExceptionHandler {


		List<BankAccount> list = accountRepository.findByMobileNumber(mobileNumber);

		if (list.isEmpty()) {
			throw new MyIndieBankGloabalExceptionHandler("MOBILE_NUMBER_IS_NOT_LINKED");
		}

		List<AccountDTO> l = new ArrayList<>();

		for (BankAccount x : list) {
			AccountDTO dto = convertToDto(x);
			l.add(dto);
		}
		return l;
	}

	@Override
	public Double checkBalance(Long mobileNumber, Long accountNumber) throws MyIndieBankGloabalExceptionHandler {

		BankAccount ba = accountRepository.findByAccountNumber(accountNumber);
		DigitalBankAccount dba = digitalBankAccountRepository.findByAccountNumber(accountNumber);

		if (ba != null) {
			if (dba != null) {

				if (dba.getAccountNumber() == accountNumber) {
					double blc = ba.getBalance();
					return blc;
				} else {
					throw new MyIndieBankGloabalExceptionHandler("ENTER_THE_CORRECT_ACCOUNT_NUMBER");
				}
			}
			throw new MyIndieBankGloabalExceptionHandler("THIS_IS_NOT_DIGITAL_ACCOUNT");
		} else
			throw new MyIndieBankGloabalExceptionHandler("NO_ACCOUNT_FOUND");
	}

}
