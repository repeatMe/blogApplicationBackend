package com.abhishek.blog.services;

import java.util.List;

import com.abhishek.blog.entites.Post;
import com.abhishek.blog.payloads.PostDto;

public interface PostService {

	PostDto createPost(PostDto postDtoInteger,Integer userId, Integer categoryId);
	PostDto updatePost(PostDto postDto,Integer postId);
	void deletePost(Integer postId);
	PostDto getPostById(Integer postId);
	List<PostDto> getAllPost(Integer pageNumber,Integer pageSize);
	List<PostDto>getPostsByCategory(Integer categoryId);
	List<PostDto>getPostsByUser(Integer userId);
	
	
}
