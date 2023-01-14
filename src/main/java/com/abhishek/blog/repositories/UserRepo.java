package com.abhishek.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhishek.blog.entites.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
