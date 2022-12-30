package service;

import java.util.List;

import dao.UserDao;
import model.Blog;
import model.User;

public class UserService {

	private UserDao userDao = new UserDao();

	public void createUser(User user) {
		userDao.createUser(user);
	}

	public List<User> getAllUser() {
		return userDao.findAllUsers();
	}

}
