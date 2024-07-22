package com.rbi.MyIndieBank.User.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserDTO {

	@NotNull(message = " Mobile Number Cannot be Null")
	@Pattern(regexp = "[0-9]{10}", message ="minimum length of Mobile number should be 10 and maximum length should be 10")
	long mobileNumber;

	int userld;

	@Size(min = 3, max = 50, message = "minimum length of Account Holder Name should be 3 and maximum length should be 50.")
	String accountHolerName;

	@NotNull(message = "Account holder name cannot be null")
	@Pattern(regexp = "(MALE | FEMALE)", message = "Gender must be Male or Female")
	String gender;

	@Past(message = "Date Of Birth Must be a Past Date")
	LocalDate dateOfBirth;

	@NotNull(message = "")
	@Size(min = 5, max = 10, message = " minimum length of Password should be 5 and maximum length should be 16")
	String password;

	@Email
	String email;

	@NotNull(message = "Communication Address should not be null")
	@Size(min = 3, max = 50, message = "minimum length of address should be 3 and maximum length should be 50.")
	String communicationAddress;

	@NotNull(message = "PAN should not be null")
	@Size(max = 10, message = " maximum length of PAN should be 10")
	// @Pattern (regexp "[A-Z][5][0-9][4][A-Z]{1}", message "PAN Must follow the //
	// pattern 5 capital characters followed by 4
	// + "digits followed by 1 capital character.")
	String pan;

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getUserld() {
		return userld;
	}

	public void setUserld(int userld) {
		this.userld = userld;
	}

	public String getAccountHolerName() {
		return accountHolerName;
	}

	public void setAccountHolerName(String accountHolerName) {
		this.accountHolerName = accountHolerName;
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

}
