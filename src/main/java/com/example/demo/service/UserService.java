package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	public List<User> listAllUsers(){
		return userRepo.findAll();
	}
	
	// implement list user by id, save user and delete user
	
	public User saveUser(User user) {
		return userRepo.save(user);
	}
	
	public void deleteUser(long id) {
		userRepo.deleteById(id);
	}
}
