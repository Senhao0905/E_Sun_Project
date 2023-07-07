package com.example.E_Sun_Project.vo.postVo;

import com.example.E_Sun_Project.entity.Post;

public class DelPostResponse {

	
	private String message ;

	public DelPostResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DelPostResponse(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	} 
	
	
}
