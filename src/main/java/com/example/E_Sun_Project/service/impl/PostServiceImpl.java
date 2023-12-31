package com.example.E_Sun_Project.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.E_Sun_Project.constant.RtnCode;
import com.example.E_Sun_Project.entity.Post;

import com.example.E_Sun_Project.repository.PostDao;

import com.example.E_Sun_Project.service.ifs.PostService;

import com.example.E_Sun_Project.vo.postVo.AddPostResponse;
import com.example.E_Sun_Project.vo.postVo.DelPostResponse;
import com.example.E_Sun_Project.vo.postVo.GetPostResponse;
import com.example.E_Sun_Project.vo.postVo.UpdatePostResponse;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDao postDao;

	@Override
	public AddPostResponse addPost(String content, HttpSession session) {

		// 檢查是否登入過
		String userId = (String) session.getAttribute("account");

		String pwd = (String) session.getAttribute("pwd");

		if (!StringUtils.hasText(userId) || !StringUtils.hasText(pwd)) {
			return new AddPostResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
		}

		if (!StringUtils.hasText(content)) {
			return new AddPostResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}

		Post post = new Post(userId, content);

		return new AddPostResponse(RtnCode.SUCCESSFUL.getMessage(), postDao.save(post));
	}

	@Override
	public DelPostResponse delPost(int postId, HttpSession session) {

		// 檢查是否登入過
		String userId = (String) session.getAttribute("account");

		String pwd = (String) session.getAttribute("pwd");

		if (!StringUtils.hasText(userId) || !StringUtils.hasText(pwd)) {
			return new DelPostResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
		}

		Post res = postDao.findByPostIdAndUserId(postId, userId);

		if (res == null) {
			return new DelPostResponse(RtnCode.NOT_FOUND.getMessage());
		}

		postDao.delete(res);
		return new DelPostResponse(RtnCode.SUCCESSFUL.getMessage());
	}

	@Override
	public UpdatePostResponse updatePost(int postId, String content, HttpSession session) {

		// 檢查是否登入過
		String userId = (String) session.getAttribute("account");

		String pwd = (String) session.getAttribute("pwd");

		if (!StringUtils.hasText(userId) || !StringUtils.hasText(pwd)) {
			return new UpdatePostResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
		}

		if (!StringUtils.hasText(content)) {
			return new UpdatePostResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}
		Post res = postDao.findByPostIdAndUserId(postId, userId);

		if (res == null) {
			return new UpdatePostResponse(RtnCode.NOT_FOUND.getMessage());
		}

		res.setContent(content);
		res.setCreatedTime(LocalDateTime.now());

		return new UpdatePostResponse(RtnCode.SUCCESSFUL.getMessage(), postDao.save(res));
	}

	@Override
	public GetPostResponse getAllPost() {

		List<Post> res = postDao.SearchAllPost();

		if (CollectionUtils.isEmpty(res)) {
			return new GetPostResponse(RtnCode.NOT_FOUND.getMessage(), res);
		}
		return new GetPostResponse(RtnCode.SUCCESSFUL.getMessage(), res);
	}

	@Override
	public GetPostResponse getPostByPostId(int postId, HttpSession session) {

		// 檢查是否登入過
		String userId = (String) session.getAttribute("account");

		String pwd = (String) session.getAttribute("pwd");

		if (!StringUtils.hasText(userId) || !StringUtils.hasText(pwd)) {
			return new GetPostResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
		}

		Optional<Post> op = postDao.findById(postId);

		if (op.isEmpty()) {
			return new GetPostResponse(RtnCode.NOT_FOUND.getMessage());
		}

		return new GetPostResponse(RtnCode.SUCCESSFUL.getMessage(), op.get());
	}

	@Override
	public GetPostResponse getPostByUser(int postId, HttpSession session) {

		// 檢查是否登入過
		String userId = (String) session.getAttribute("account");

		String pwd = (String) session.getAttribute("pwd");

		if (!StringUtils.hasText(userId) || !StringUtils.hasText(pwd)) {
			return new GetPostResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
		}

		Post res = postDao.findByPostIdAndUserId(postId, userId);
		
		if(res == null) {
			return new GetPostResponse(RtnCode.NOT_FOUND.getMessage());
		}
		
		
		return new GetPostResponse(RtnCode.SUCCESSFUL.getMessage(), res);
	}

}
