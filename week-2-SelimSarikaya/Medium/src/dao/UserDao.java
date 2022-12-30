package dao;

import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDao {

	private static List<User> userList = new ArrayList<>();

	public void createUser(User user) {
		userList.add(user);
	}

	public List<User> findAllUsers() {
		return userList;
	}

}
