package com.example.E_Sun_Project.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.E_Sun_Project.entity.Comment;



@Repository
public interface CommentDao extends JpaRepository<Comment,Integer> {
	
	@Query(value = "select * from comment where post_id = :postId order by comment_id desc" , nativeQuery = true)
	public List<Comment> searchCommentByPostId(
			@Param("postId")int postId);
		
}
