package com.example.E_Sun_Project.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.example.E_Sun_Project.entity.User;

@Repository
public interface UserDao extends JpaRepository<User,String> {
	
	
		
}
