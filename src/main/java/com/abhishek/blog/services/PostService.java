package com.abhishek.blog.services;

import java.util.List;

import com.abhishek.blog.entites.Post;
import com.abhishek.blog.payloads.PostDto;

public interface PostService {

	PostDto createPost(PostDto postDtoInteger,Integer userId, Integer categoryId);
	Post updatePost(PostDto postDto,Integer postId);
	void deletePost(Integer postId);
	Post getPostById(Integer postId);
	List<Post> getAllPost();
	List<PostDto>getPostsByCategory(Integer categoryId);
	List<PostDto>getPostsByUser(Integer userId);
	
	
}
