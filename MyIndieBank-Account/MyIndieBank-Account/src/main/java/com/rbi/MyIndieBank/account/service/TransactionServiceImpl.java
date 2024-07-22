package com.rbi.MyIndieBank.account.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rbi.MyIndieBank.account.dto.AccountDTO;
import com.rbi.MyIndieBank.account.dto.TransactionDTO;
import com.rbi.MyIndieBank.account.entity.BankAccount;
import com.rbi.MyIndieBank.account.entity.DigitalBankAccount;
import com.rbi.MyIndieBank.account.entity.Transaction;
import com.rbi.MyIndieBank.account.exception.MyIndieBankGloabalExceptionHandler;
import com.rbi.MyIndieBank.account.repository.AccountRepository;
import com.rbi.MyIndieBank.account.repository.DigitalBankAccountRepository;
import com.rbi.MyIndieBank.account.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	DigitalBankAccountRepository digitalBankAccountRepository;
	@Autowired
	private ModelMapper modelMapper;

	// Convert Dto to entity
	public Transaction convertToEntity(TransactionDTO transactionDTO) {
		return modelMapper.map(transactionDTO, Transaction.class);
	}

	// Convert entity to dto
	public TransactionDTO convertToDto(Transaction x) {
		return modelMapper.map(x, TransactionDTO.class);
	}

	@Override
	public String fundTransfer(TransactionDTO transactionDTO) throws MyIndieBankGloabalExceptionHandler {
		BankAccount ba = accountRepository.findByAccountNumber(transactionDTO.getSenderAccountNumber());
		if (ba == null) {
			throw new MyIndieBankGloabalExceptionHandler("NO_ACCOUNT_FOUND");
		} else {

			DigitalBankAccount dba = digitalBankAccountRepository
					.findByAccountNumber(transactionDTO.getSenderAccountNumber());
			if (dba != null) {

				if (ba.getBalance() >= transactionDTO.getAmount()) {
					BankAccount senderEntity = accountRepository
							.findByAccountNumber(transactionDTO.getSenderAccountNumber());
					senderEntity.setBalance(senderEntity.getBalance() - transactionDTO.getAmount());
					senderEntity = accountRepository.save(senderEntity);

					BankAccount recieverEntity = accountRepository
							.findByAccountNumber(transactionDTO.getReceiverAccountNumber());
					recieverEntity.setBalance(recieverEntity.getBalance() + transactionDTO.getAmount());
					recieverEntity = accountRepository.save(recieverEntity);

					Transaction t = convertToEntity(transactionDTO);
					t = transactionRepository.save(t);

					return "TRANSACTION_SUCCESSFULL :" + t.getTransactionId();
				} else {
					throw new MyIndieBankGloabalExceptionHandler("INSUFFICIANT_FUND");
				}

			} else {
				throw new MyIndieBankGloabalExceptionHandler("ACCOUNT_NOT_LINKED");
			}

		}
	}

	@Override
	public List<TransactionDTO> accountStatement(Long mobileNumber) throws MyIndieBankGloabalExceptionHandler {

		DigitalBankAccount dba = digitalBankAccountRepository.findByMobileNumber(mobileNumber);
		System.out.println(dba.toString());
		if (dba == null) {
			throw new MyIndieBankGloabalExceptionHandler("ACCOUNT_NOT_LINKED");
		}
		// if above condition gets true then below code will not be executed

		List<TransactionDTO> dtolist = new ArrayList<>();

		List<Transaction> transactionList = transactionRepository.findByAccountNumber(dba.getAccountNumber());
		if (transactionList.isEmpty()) {
			throw new MyIndieBankGloabalExceptionHandler("NO_TRANSACTION_FOUND");
		} else {
			for (Transaction x : transactionList) {
				TransactionDTO transactionDTO = convertToDto(x);
				dtolist.add(transactionDTO);
			}
		}
		return dtolist;
	}

}
