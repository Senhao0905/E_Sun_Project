package com.example.E_Sun_Project.vo.postVo;

import com.example.E_Sun_Project.entity.Post;

public class UpdatePostResponse {

	private String message;

	private Post post;

	public UpdatePostResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UpdatePostResponse(String message) {
		super();
		this.message = message;
	}

	public UpdatePostResponse(String message, Post post) {
		super();
		this.message = message;
		this.post = post;
	}

	// -----------------------------------------
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}
