package com.example.E_Sun_Project.service.ifs;

import javax.servlet.http.HttpSession;

import com.example.E_Sun_Project.vo.commentVo.AddCommentResponse;


public interface CommentService {

	public AddCommentResponse addComment(int postId , String content,HttpSession session);
	
}
