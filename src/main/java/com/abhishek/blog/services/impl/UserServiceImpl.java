package com.abhishek.blog.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.abhishek.blog.entites.User;
import com.abhishek.blog.payloads.UserDto;
import com.abhishek.blog.repositories.UserRepo;
import com.abhishek.blog.services.UserService;
import com.abhishek.blog.entites.*;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	

	@Override
	public UserDto createUser(UserDto userDto) {
		User user=this.dtoTouser(userDto);
		User savedUser=this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
	   User user =this.userRepo.findById(userId).orElseThrow((e->new ResourceNotFoundException("User","id",userId)));
		return null;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub

	}
	private User dtoTouser(UserDto userDto) {
		User user=new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getAbout());
		user.setPassword(userDto.getPassword());
        return user;		
	}
	private UserDto userToDto(User user) {
		UserDto userDto=new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setAbout(user.getAbout());
		userDto.setPassword(user.getPassword());
        return userDto;		
	}
	

}
