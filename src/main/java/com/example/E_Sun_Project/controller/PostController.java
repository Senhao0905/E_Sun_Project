package com.example.E_Sun_Project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.E_Sun_Project.service.ifs.PostService;

import com.example.E_Sun_Project.vo.postVo.AddPostRequest;
import com.example.E_Sun_Project.vo.postVo.AddPostResponse;
import com.example.E_Sun_Project.vo.postVo.DelPostRequest;
import com.example.E_Sun_Project.vo.postVo.DelPostResponse;
import com.example.E_Sun_Project.vo.postVo.GetPostResponse;
import com.example.E_Sun_Project.vo.postVo.UpdatePostRequest;
import com.example.E_Sun_Project.vo.postVo.UpdatePostResponse;


@CrossOrigin
@RestController
public class PostController {

	@Autowired
	private PostService postService;
	
	@PostMapping(value = "add_post")
	public AddPostResponse addPost(@RequestBody AddPostRequest request ,HttpSession session ) {
		return postService.addPost(request.getContent(), session);
	}
	
	@PostMapping(value = "del_post")
	public DelPostResponse delPost(@RequestBody DelPostRequest request ,HttpSession session ) {
		return postService.delPost(request.getPostId(), session);
	}
	
	@PostMapping(value = "update_post")
	public UpdatePostResponse updatePost(@RequestBody UpdatePostRequest request , HttpSession session) {
		return postService.updatePost(request.getPostId(), request.getContent(), session);
	}
	
	@GetMapping(value = "get_all_post")
	public GetPostResponse getAllPost() {
		return postService.getAllPost();
	}
	
	@PostMapping(value = "get_post_by_postID")
	public GetPostResponse getPostByPostId(@RequestBody UpdatePostRequest request , HttpSession session) {
		return postService.getPostByPostId(request.getPostId(), session);
	}
	
	@PostMapping(value = "get_post_by_user")
	public GetPostResponse getPostByUser(@RequestBody UpdatePostRequest request , HttpSession session) {
		return postService.getPostByUser(request.getPostId(), session);
	}
	
	
}
