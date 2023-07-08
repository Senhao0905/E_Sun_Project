package com.example.E_Sun_Project.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comment_id")
	private int commentId;
	
	@Column(name = "user_id")
	private String userId;

	@Column(name = "post_id")
	private int postId;
	
	@Column(name = "content")
	private String content;

	@Column(name = "created_time")
	private LocalDateTime createdTime = LocalDateTime.now();

	
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Comment(String userId, int postId, String content) {
		super();
		this.userId = userId;
		this.postId = postId;
		this.content = content;
	}



	//------------------------------------------------
	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	

	public int getPostId() {
		return postId;
	}



	public void setPostId(int postId) {
		this.postId = postId;
	}



	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	
	

	
}
