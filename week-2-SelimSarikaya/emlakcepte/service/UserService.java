package emlakcepte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlakcepte.dao.UserDao;
import emlakcepte.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;

	
	// Singleton Pattern	
/*	private static UserService userService = new UserService();
	
	private UserService() {
		
	}
	
	public static UserService getDifferentInstance() {
		return  new UserService();
	}
	
	public static UserService getSameInstance() {
		return userService;
	}
	*/
	public void createUser(User user) {		
		//UserDao userDao = new UserDao(); tekrar tekrar oluşturmamıza gerek yok
		System.out.println("ben bir userDao objesiyim:" + userDao.toString());
		
		if (user.getPassword().length() < 5) {
			System.out.println("Şifre en az 5 karakterli olmalı");
		}			
		userDao.createUser(user);		
	}
	
	public List<User> getAllUser() {
		//UserDao userDao = new UserDao();		
		return userDao.findAllUsers();
	}
	
	public void printAllUser() {
		
		getAllUser().forEach(user -> System.out.println(user.getName()));
		
	}
	
	public void updatePassword(User user, String newPassword) {
		if (getAllUser().stream().filter(usr -> usr.getName().equals(user.getName())) != null) {
			user.setPassword(newPassword);
		}

	}
	public void saveSearch(String keyword, User user) {
		if (getAllUser().stream().filter(usr -> usr.getName().equals(user.getName())) != null) {
			user.setSearchList(List.of(keyword));
		}

	}
	public void listSearch(User user) {
		 getAllUser().stream().filter(t -> t.getName().equals(user.getName())).forEach(y -> System.out.println(y.getSearchList()));
	}

	

}
