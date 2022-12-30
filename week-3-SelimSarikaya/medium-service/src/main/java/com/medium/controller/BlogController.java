package com.medium.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medium.model.Blog;
import com.medium.service.BlogService;
@RestController
public class BlogController {
	
	@Autowired
	private BlogService blogService;

	@GetMapping
	public List<Blog> getAll() {
		return blogService.getAll();
	}
	
	@PostMapping
	public Blog create(Blog blog) {
		blogService.createBlog(blog);
		return blog;
	}
}
