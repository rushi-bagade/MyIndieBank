package com.rbi.MyIndieBank.User.utility;

public class ErrorInfo {

	private int errorCode;
	private String errorMsg;
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	@Override
	public String toString() {
		return "ErrorInfo [errorCode=" + errorCode + ", errorMsg=" + errorMsg + "]";
	}
	
	
}
