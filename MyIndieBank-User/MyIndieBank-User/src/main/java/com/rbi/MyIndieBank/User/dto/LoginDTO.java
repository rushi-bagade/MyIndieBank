package com.rbi.MyIndieBank.User.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginDTO {

	Long mobileNumber;

	@NotNull(message = "bb")
	@Size(min = 5, max = 10, message = "minimum length of Password should be 5 and maximum length should be 10")
	String password;

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginDTO [mobileNumber=" + mobileNumber + ", password=" + password + "]";
	}

}