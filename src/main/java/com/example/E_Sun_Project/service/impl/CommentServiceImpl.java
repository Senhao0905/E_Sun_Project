package com.example.E_Sun_Project.service.impl;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.E_Sun_Project.constant.RtnCode;
import com.example.E_Sun_Project.entity.Comment;
import com.example.E_Sun_Project.entity.Post;
import com.example.E_Sun_Project.repository.CommentDao;
import com.example.E_Sun_Project.repository.PostDao;
import com.example.E_Sun_Project.service.ifs.CommentService;

import com.example.E_Sun_Project.vo.commentVo.AddCommentResponse;
import com.example.E_Sun_Project.vo.commentVo.GetCommentResponse;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;

	@Autowired
	private PostDao postDao;

	@Override
	public AddCommentResponse addComment(int postId, String content, HttpSession session) {

		// 檢查是否登入過
		String userId = (String) session.getAttribute("account");

		String pwd = (String) session.getAttribute("pwd");

		if (!StringUtils.hasText(userId) || !StringUtils.hasText(pwd)) {
			return new AddCommentResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
		}

		// 檢查發文是否存在
		Optional<Post> op = postDao.findById(postId);
		if (op.isEmpty()) {
			return new AddCommentResponse(RtnCode.NOT_FOUND.getMessage());
		}

		// 檢查發文內容是否為空
		if (!StringUtils.hasText(content)) {
			return new AddCommentResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}

		Comment comment = new Comment(userId, postId, content);

		return new AddCommentResponse(RtnCode.SUCCESSFUL.getMessage(), commentDao.save(comment));
	}

	@Override
	public GetCommentResponse getCommentByPostId(int postId, HttpSession session) {

		// 檢查是否登入過
		String userId = (String) session.getAttribute("account");

		String pwd = (String) session.getAttribute("pwd");

		if (!StringUtils.hasText(userId) || !StringUtils.hasText(pwd)) {
			return new GetCommentResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
		}

		List<Comment> res = commentDao.searchCommentByPostId(postId);
		
		if(CollectionUtils.isEmpty(res)) {
			return new GetCommentResponse(RtnCode.NOT_FOUND.getMessage());
		}
		
		return new GetCommentResponse(RtnCode.SUCCESSFUL.getMessage(), res);
	}

}
