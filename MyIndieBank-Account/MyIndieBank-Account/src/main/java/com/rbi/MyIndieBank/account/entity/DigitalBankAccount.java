package com.rbi.MyIndieBank.account.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity 
public class DigitalBankAccount {
	@Id
	@GeneratedValue(generator = "digital_banking_id")
	@GenericGenerator(name = "digital_banking_id",strategy="com.rbi.MyIndieBank.account.utility.DigitalBankingIdGenerator")
	private String digitalBankingId;
	private long mobileNumber;
	private long accountNumber;
	private String accountType;
	
	
	public String getDigitalBankingId() {
		return digitalBankingId;
	}
	public void setDigitalBankingId(String digitalBankingId) {
		this.digitalBankingId = digitalBankingId;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	@Override
	public String toString() {
		return "DigitalBankAccount [digitalBankingId=" + digitalBankingId + ", mobileNumber=" + mobileNumber
				+ ", accountNumber=" + accountNumber + ", accountType=" + accountType + "]";
	}
	
	
	
}
