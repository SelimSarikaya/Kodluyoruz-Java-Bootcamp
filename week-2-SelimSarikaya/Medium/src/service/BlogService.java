package service;

import java.util.List;

import dao.BlogDao;
import model.Blog;
import model.User;

public class BlogService {

	private BlogDao blogDao = new BlogDao();
	private UserService userService = new UserService();

	public void createBlog(Blog blog) {
		blogDao.createBlog(blog);
	}

	public List<Blog> getAll() {
		return blogDao.findAllBlogs();
	}

	public void printAll(List<Blog> blogList) {
		blogList.forEach(blog -> System.out.println(blog));
	}

	public void updateBlog(Blog blog) {
		blogDao.updateBlog(blog);
	}

	public void deleteBlog(Blog blog) {
		blogDao.deleteBlog(blog);
	}

	public List<Blog> getAllByUserName(User user) {
		return getAll().stream().filter(realty -> realty.getUser().getBlogs().equals(user.getBlogs())).toList();

	}

	public void deleteBlog(User user, Blog blog) {
		userService.getAllUser().stream().filter(t -> t.getName().equals(user)).forEach(t -> t.getBlogs().remove(blog));
		;

		// .forEach(t -> user.getBlogs().remove(blog));
	}

}
