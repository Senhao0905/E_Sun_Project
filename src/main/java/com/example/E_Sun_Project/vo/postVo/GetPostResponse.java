package com.example.E_Sun_Project.vo.postVo;

import java.util.List;

import com.example.E_Sun_Project.entity.Post;

public class GetPostResponse {

	private String message;

	private List<Post> posts;
	
	private Post post ;

	public GetPostResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetPostResponse(String message) {
		super();
		this.message = message;
	}

	public GetPostResponse(String message, List<Post> posts) {
		super();
		this.message = message;
		this.posts = posts;
	}

	public GetPostResponse(String message, Post post) {
		super();
		this.message = message;
		this.post = post;
	}

	// --------------------------------
	
	public String getMessage() {
		return message;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

}
