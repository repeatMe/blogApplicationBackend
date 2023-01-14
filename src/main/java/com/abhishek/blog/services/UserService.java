package com.abhishek.blog.services;

import java.util.List;

import com.abhishek.blog.entites.User;
import com.abhishek.blog.payloads.UserDto;

public interface UserService {

	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user, Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto> getAllUsers();
	void deleteUser(Integer userId);
	
	
	
		
		
	
}
