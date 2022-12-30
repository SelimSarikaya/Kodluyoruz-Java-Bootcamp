package com.medium.service;

import java.util.List;
import com.medium.repository.BlogRepository;
import com.medium.model.Blog;
import com.medium.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;
	@Autowired
	private UserService userService;

	public void createBlog(Blog blog) {
		blogRepository.createBlog(blog);
	}

	public List<Blog> getAll() {
		return blogRepository.findAllBlogs();
	}

	public void printAll(List<Blog> blogList) {
		blogList.forEach(blog -> System.out.println(blog));
	}

	public void updateBlog(Blog blog) {
		blogRepository.updateBlog(blog);
	}

	public void deleteBlog(Blog blog) {
		blogRepository.deleteBlog(blog);
	}

	public List<Blog> getAllByUserName(User user) {
		return getAll().stream().filter(realty -> realty.getUser().getBlogs().equals(user.getBlogs())).toList();

	}

	public void deleteBlog(User user, Blog blog) {
		userService.getAllUser().stream().filter(t -> t.getName().equals(user)).forEach(t -> t.getBlogs().remove(blog));

		// .forEach(t -> user.getBlogs().remove(blog));
	}

}
