package com.abhishek.blog.payloads;

import java.util.Date;

import com.abhishek.blog.entites.Category;
import com.abhishek.blog.entites.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

	private String title;
	private String content;
	private String imageName;
	private Date addedDate;
	private CategoryDto category;
	private UserDto user;
}