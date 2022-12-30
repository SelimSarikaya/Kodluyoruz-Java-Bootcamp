package model;

import java.util.List;

public class User {

	private String name;
	private String email;
	private List<User> following;
	private List<Blog> blogs;
	private List<String> followedTags;

	public User() {
		super();
	}

	public User(String name, String email, List<User> following, List<Blog> blogs, List<String> followedTags) {
		super();
		this.name = name;
		this.email = email;
		this.following = following;
		this.blogs = blogs;
		this.followedTags = followedTags;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<User> getFollowing() {
		return following;
	}

	public void setFollowing(List<User> following) {
		this.following = following;
	}

	public List<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}

	public List<String> getFollowedTags() {
		return followedTags;
	}

	public void setFollowedTags(List<String> followedTags) {
		this.followedTags = followedTags;
	}

	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}

}
