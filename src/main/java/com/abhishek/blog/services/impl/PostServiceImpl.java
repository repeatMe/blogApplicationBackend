package com.abhishek.blog.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhishek.blog.entites.Category;
import com.abhishek.blog.entites.Post;
import com.abhishek.blog.entites.User;
import com.abhishek.blog.exceptions.ResourceNotFoundException;
import com.abhishek.blog.payloads.PostDto;
import com.abhishek.blog.repositories.CategoryRepo;
import com.abhishek.blog.repositories.PostRepo;
import com.abhishek.blog.repositories.UserRepo;
import com.abhishek.blog.services.PostService;


@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired 
	private CategoryRepo categoryRepo;
	

	@Override
	public PostDto createPost(PostDto postDto,Integer userId, Integer categoryId) {
		
	User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","User id",userId));
    Category category=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","category id",categoryId));
    
     Post post=this.modelMapper.map(postDto, Post.class);
     post.setImageName("default.png");
	 post.setAddedDate(new Date());
	 post.setUser(user);
	 post.setCategory(category);
	 Post newPost=this.postRepo.save(post);
     return this.modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public Post updatePost(PostDto postDto, Integer postId) {
	
		return null;
	}

	@Override
	public void deletePost(Integer postId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Post> getAllPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getPostById(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getPostsByCategory(Integer categoryId) {
		Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Category id",categoryId));
		
		List<Post>posts=this.postRepo.findByCategory(cat);
		List<PostDto>postDtos=posts.stream().map((post)->this.modelMapper.map(posts, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public List<PostDto> getPostsByUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
