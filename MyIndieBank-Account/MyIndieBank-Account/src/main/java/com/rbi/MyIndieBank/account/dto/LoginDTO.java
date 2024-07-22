package com.rbi.MyIndieBank.account.dto;

import jakarta.validation.constraints.NotNull;

public class LoginDTO {

	@NotNull
	private Long mobileNumber; 
	
	@NotNull
	private String password;

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
	
	
}
