package com.medium.repository;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.medium.model.User;

@Repository
public class UserRepository {

	private static List<User> userList = new ArrayList<>();

	public void createUser(User user) {
		userList.add(user);
	}

	public List<User> findAllUsers() {
		return userList;
	}

}
