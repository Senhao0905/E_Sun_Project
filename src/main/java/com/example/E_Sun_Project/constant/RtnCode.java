package com.example.E_Sun_Project.constant;

public enum RtnCode {

	SUCCESSFUL("200","Successful !"),
	CANNOT_EMPTY("400","Can not empty!!"),
	DATA_ERROR("400","Data is error!!"),
	DATE_ERROR("400","Date is error ! "),
	NOT_FOUND("404","Not found"),
	USER_NOT_EXISTS("400","User is not exists !"),
	PWD_ERROR("400","Password Incorrect !"),
	PLEASE_LOGIN_FIRST("400","Plz Login !"),
	ERROR("400","Error  ! ");
	
	private String code;
	
	private String message;

	private RtnCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
