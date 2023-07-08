package com.example.E_Sun_Project.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.E_Sun_Project.entity.Post;


@Repository
public interface PostDao extends JpaRepository<Post,Integer> {
	
	public Post findByPostIdAndUserId(int postId , String userId);
		
}
