package com.rbi.MyIndieBank.account.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AccountDTO {

	@NotNull
	@Min(value = 7, message = "Minimum length should be 7")
	private Long accountNumber;
	
	@NotNull(message = "Bankname cannot be null")
	@Min(value = 5, message = "Minimum length should be 5")
	@Max(value = 15, message = "Maximum length should be 15")
	private String bankName;

	@NotNull
	@Min(value = 0, message = "Minimum balance must be 0")
	private Double balance;

	@NotNull(message = "Account Type cannot be null")
	@Size(min=5, max = 10)
	private String accountType;

	@NotNull
	private String ifscCode;

	@NotNull
	private LocalDate openingDate;

	@NotNull
	private Long mobileNumber;

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public LocalDate getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(LocalDate openingDate) {
		this.openingDate = openingDate;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	
	
}
