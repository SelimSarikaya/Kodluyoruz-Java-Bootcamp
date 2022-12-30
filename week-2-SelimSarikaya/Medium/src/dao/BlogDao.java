package dao;

import java.util.ArrayList;
import java.util.List;

import model.Blog;
import model.BlogType;

public class BlogDao {
	
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
