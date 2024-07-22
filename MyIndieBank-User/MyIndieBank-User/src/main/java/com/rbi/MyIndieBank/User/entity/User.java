package com.rbi.MyIndieBank.User.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	long mobileNumber;

//	@GeneratedValue(generator = "user_id")
//	@GenericGenerator (name = "user_id", strategy "com.infyMeMobile.user.Utility. UserIdGenerator")
//	@Column(name = "user_id")
//	@GeneratedValue(strategy GenerationType. IDENTITY)

	int userId;   // cant auto generate
	String accountHolderName;
	String gender;
	LocalDate dateOfBirth;
	String password;
	String email;
	String communicationAddress;
	String pan;
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCommunicationAddress() {
		return communicationAddress;
	}
	public void setCommunicationAddress(String communicationAddress) {
		this.communicationAddress = communicationAddress;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	@Override
	public String toString() {
		return "User [mobileNumber=" + mobileNumber + ", userId=" + userId + ", accountHolderName=" + accountHolderName
				+ ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", password=" + password + ", email=" + email
				+ ", communicationAddress=" + communicationAddress + ", pan=" + pan + "]";
	}
	
	
	
}
