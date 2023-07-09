package com.example.E_Sun_Project.service.ifs;

import javax.servlet.http.HttpSession;

import com.example.E_Sun_Project.vo.commentVo.AddCommentResponse;
import com.example.E_Sun_Project.vo.commentVo.GetCommentResponse;


public interface CommentService {

	public AddCommentResponse addComment(int postId , String content,HttpSession session);
	
	public GetCommentResponse getCommentByPostId(int postId , HttpSession session);
}
