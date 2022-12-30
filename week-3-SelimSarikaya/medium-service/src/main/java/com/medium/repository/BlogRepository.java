package com.medium.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.medium.model.Blog;
import com.medium.model.BlogType;

@Repository
public class BlogRepository {

	public static List<Blog> blogList = new ArrayList<>();

	public void createBlog(Blog blog) {
		blogList.add(blog);
	}

	public List<Blog> findAllBlogs() {
		return blogList;
	}

	public void updateBlog(Blog blog) {
		blog.setContent(blog.getContent());
	}

	public void deleteBlog(Blog blog) {
		blog.setType(BlogType.DELETED);

	}

}
