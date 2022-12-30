package com.medium.service;

import java.util.List;
import com.medium.repository.UserRepository;

import com.medium.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void createUser(User user) {
		userRepository.createUser(user);
	}

	public List<User> getAllUser() {
		return userRepository.findAllUsers();
	}

}
