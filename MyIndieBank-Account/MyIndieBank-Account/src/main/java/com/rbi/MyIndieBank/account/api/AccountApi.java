package com.rbi.MyIndieBank.account.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rbi.MyIndieBank.account.dto.AccountDTO;
import com.rbi.MyIndieBank.account.dto.TransactionDTO;
import com.rbi.MyIndieBank.account.exception.MyIndieBankGloabalExceptionHandler;
import com.rbi.MyIndieBank.account.service.AccountService;
import com.rbi.MyIndieBank.account.service.DigitalBankAccountService;
import com.rbi.MyIndieBank.account.service.TransactionService;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/myindiebank")
public class AccountApi {

	@Autowired
	AccountService accountService;

	@Autowired
	DigitalBankAccountService digitalBankAccountService;

	@Autowired
	TransactionService transactionService;

	@PostMapping("/accounts") // createAccount
	ResponseEntity<String> createAccount(@RequestBody @Valid AccountDTO accountDTO) {

		String str = accountService.createAccount(accountDTO);
		return new ResponseEntity<>(str, HttpStatus.CREATED);
	}

	@GetMapping("/accounts/{mobileNumber}") // listAccounts
	ResponseEntity<List<AccountDTO>> listAccounts(@PathVariable Long mobileNumber)
			throws MyIndieBankGloabalExceptionHandler {

		List<AccountDTO> aList = accountService.listAccounts(mobileNumber);
		return new ResponseEntity<>(aList, HttpStatus.OK);

	}

	@PostMapping("/accounts/{mobileNumber}/{accountNumber}") // linkAccount
	ResponseEntity<String> linkAccount(@PathVariable Long mobileNumber, @PathVariable Long accountNumber)
			throws MyIndieBankGloabalExceptionHandler {

		String str = digitalBankAccountService.linkAccount(mobileNumber, accountNumber);
		return new ResponseEntity<>(str, HttpStatus.CREATED);

	}

	@PostMapping("/accounts/{mobileNumber}/{accountNumber}/{otp}")  //link account with otp
	ResponseEntity<String> linkAccount(@PathVariable Long mobileNumber, @PathVariable Long accountNumber,
			@PathVariable Integer otp) throws MyIndieBankGloabalExceptionHandler {

		String str = digitalBankAccountService.linkAccount(mobileNumber, accountNumber, otp);
		return new ResponseEntity(str, HttpStatus.CREATED);

	}

	@GetMapping("/accounts/{mobileNumber}/{accountNumber}")  //Check balance
	ResponseEntity<Double> checkBalance(@PathVariable Long mobileNumber, @PathVariable Long accountNumber)
			throws MyIndieBankGloabalExceptionHandler {

		Double balance = accountService.checkBalance(mobileNumber, accountNumber);
		return new ResponseEntity<>(balance, HttpStatus.OK);

	}

	@PutMapping("/accounts/fundtransfer")   // fund transfer
	ResponseEntity<String> fundTransfer(@RequestBody @Valid TransactionDTO transactionDTO)
			throws MyIndieBankGloabalExceptionHandler {
		String str = transactionService.fundTransfer(transactionDTO);
		return new ResponseEntity<>(str, HttpStatus.OK);
	}
	

	@GetMapping("/accounts/statement/{mobileNumber}")   //account Statement
	ResponseEntity<List<TransactionDTO>> accountStatement(@PathVariable Long mobileNumber)
			throws MyIndieBankGloabalExceptionHandler {

		List<TransactionDTO> listDto = transactionService.accountStatement(mobileNumber);

		return new ResponseEntity(listDto, HttpStatus.OK);

	}

}
