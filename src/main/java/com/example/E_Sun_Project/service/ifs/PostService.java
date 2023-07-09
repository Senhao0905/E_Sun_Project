package com.example.E_Sun_Project.service.ifs;

import javax.servlet.http.HttpSession;


import com.example.E_Sun_Project.vo.postVo.AddPostResponse;
import com.example.E_Sun_Project.vo.postVo.DelPostResponse;
import com.example.E_Sun_Project.vo.postVo.GetPostResponse;
import com.example.E_Sun_Project.vo.postVo.UpdatePostResponse;

public interface PostService {

	
	public AddPostResponse addPost(String content ,HttpSession session );
	
	public DelPostResponse delPost(int postId , HttpSession session);
	
	public UpdatePostResponse updatePost(int postId,String content , HttpSession session);
	
	public GetPostResponse getAllPost();
	
	public GetPostResponse getPostByPostId(int postId , HttpSession session);
	
	public GetPostResponse getPostByUser(int postId , HttpSession session);
}
