package com.example.E_Sun_Project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.E_Sun_Project.service.ifs.CommentService;
import com.example.E_Sun_Project.service.ifs.PostService;
import com.example.E_Sun_Project.vo.commentVo.AddCommentRequest;
import com.example.E_Sun_Project.vo.commentVo.AddCommentResponse;
import com.example.E_Sun_Project.vo.postVo.AddPostRequest;
import com.example.E_Sun_Project.vo.postVo.AddPostResponse;
import com.example.E_Sun_Project.vo.postVo.DelPostRequest;
import com.example.E_Sun_Project.vo.postVo.DelPostResponse;
import com.example.E_Sun_Project.vo.postVo.GetPostResponse;
import com.example.E_Sun_Project.vo.postVo.UpdatePostRequest;
import com.example.E_Sun_Project.vo.postVo.UpdatePostResponse;


@CrossOrigin
@RestController
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@PostMapping(value = "add_comment")
	public AddCommentResponse addComment(@RequestBody AddCommentRequest request,HttpSession session) {
		return commentService.addComment(request.getPostId(), request.getContent(), session);
	}
	
	
	
	
}
