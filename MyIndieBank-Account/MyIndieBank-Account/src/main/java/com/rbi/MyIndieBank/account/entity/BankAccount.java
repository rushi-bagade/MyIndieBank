package com.rbi.MyIndieBank.account.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="sequence",sequenceName="sequence", initialValue=50001, allocationSize = 1)
public class BankAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sequence")
    private Long accountNumber;
	
	private String bankName;

	private Double balance;

	private String accountType;

	private String ifscCode;

	private LocalDate openingDate;

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

	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", bankName=" + bankName + ", balance=" + balance
				+ ", accountType=" + accountType + ", ifscCode=" + ifscCode + ", openingDate=" + openingDate
				+ ", mobileNumber=" + mobileNumber + "]";
	}
	
	
}
