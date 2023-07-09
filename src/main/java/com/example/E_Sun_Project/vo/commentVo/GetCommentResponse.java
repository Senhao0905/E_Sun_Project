package com.example.E_Sun_Project.vo.commentVo;

import java.util.List;

import com.example.E_Sun_Project.entity.Comment;

public class GetCommentResponse {

	private String message;

	private List<Comment> comments;

	public GetCommentResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetCommentResponse(String message) {
		super();
		this.message = message;
	}

	public GetCommentResponse(String message, List<Comment> comments) {
		super();
		this.message = message;
		this.comments = comments;
	}

	// ----------------------------------------

	public List<Comment> getComments() {
		return comments;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}
