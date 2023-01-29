package com.abhishek.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhishek.blog.entites.User;
import com.abhishek.blog.exceptions.ResourceNotFoundException;
import com.abhishek.blog.payloads.UserDto;
import com.abhishek.blog.repositories.UserRepo;
import com.abhishek.blog.services.UserService;
import com.abhishek.blog.entites.*;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;

    @Autowired
	ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user=this.dtoTouser(userDto);
		User savedUser=this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
	   User user =this.userRepo.findById(userId)
			   .orElseThrow(()->new ResourceNotFoundException("User","id",userId));
	 user.setName(userDto.getName());
	 user.setEmail(userDto.getEmail());
	 user.setPassword(userDto.getPassword());
	 user.setAbout(userDto.getAbout());
	 User updateUser=this.userRepo.save(user);
	 UserDto userDto1=this.userToDto(updateUser);
	
	   return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user =this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
		
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		 List<User>users=this.userRepo.findAll();
		 List<UserDto>userDto=users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		 return userDto;
		 
		  
	}

	@Override
	public void deleteUser(Integer userId) {
	User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
		this.userRepo.delete(user);

	}
	private User dtoTouser(UserDto userDto) {
		//with model mapper pass two arguments one is object that need to change
		//to other one which is class
		User user=this.modelMapper.map(userDto, User.class);
		//without model mapper
//		User user=new User();
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setAbout(userDto.getAbout());
//		user.setPassword(userDto.getPassword());
        return user;		
	}
	private UserDto userToDto(User user) {
//		UserDto userDto=new UserDto();
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setAbout(user.getAbout());
//		userDto.setPassword(user.getPassword());
		UserDto userDto=this.modelMapper.map(user, UserDto.class);
        return userDto;		
	}
	

}
