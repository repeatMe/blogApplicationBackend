package com.abhishek.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhishek.blog.entites.Category;
import com.abhishek.blog.entites.Post;
import com.abhishek.blog.entites.User;

public interface PostRepo extends JpaRepository<Post,Integer> {
	
List<Post>findByUser(User user);
List<Post>findByCategory(Category categories);
}
