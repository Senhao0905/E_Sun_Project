package com.example.E_Sun_Project.vo.commentVo;

import com.example.E_Sun_Project.entity.Comment;

public class AddCommentResponse {

	private String message;

	private Comment comment;

	public AddCommentResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddCommentResponse(String message) {
		super();
		this.message = message;
	}

	public AddCommentResponse(String message, Comment comment) {
		super();
		this.message = message;
		this.comment = comment;
	}

	// -----------------------------------------
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

}
