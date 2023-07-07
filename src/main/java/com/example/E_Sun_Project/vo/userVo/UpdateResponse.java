package com.example.E_Sun_Project.vo.userVo;

import com.example.E_Sun_Project.entity.User;

public class UpdateResponse {

	private String message;

	private User user;

	public UpdateResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UpdateResponse(String message) {
		super();
		this.message = message;
	}

	public UpdateResponse(String message, User user) {
		super();
		this.message = message;
		this.user = user;
	}

	// ------------------------------------
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
