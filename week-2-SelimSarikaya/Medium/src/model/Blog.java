package model;

import java.util.List;

public class Blog {

	private String title;
	private String content;
	private BlogType type;
	private User user;

	public Blog() {
		super();
	}

	public Blog(String title, String content, BlogType type, User user) {
		super();
		this.title = title;
		this.content = content;
		this.type = type;
		this.user = user;

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public BlogType getType() {
		return type;
	}

	public void setType(BlogType type) {
		this.type = type;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Blog [title=" + title + "]";
	}

}
