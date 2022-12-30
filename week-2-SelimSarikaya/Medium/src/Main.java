
import java.util.List;

import model.Blog;
import model.BlogType;
import model.User;
import service.BlogService;
import service.UserService;

public class Main {
	
	public static void main(String[] args) {

		User userSelim = new User("Selim", "selim@gmail.com", null, null, null);
		User userCem = new User("Cem", "cem@gmail.com", null, null, null);
		User userMerve = new User("Merve", "merve@gmail.com", null, null, null);

		UserService userService = new UserService();

		userService.createUser(userCem);
		userService.createUser(userSelim);
		userService.createUser(userMerve);

		userCem.setFollowing(List.of(userMerve, userSelim));
		userMerve.setFollowing(List.of(userSelim));
		userSelim.setFollowing(List.of(userCem));
		System.out.println("Cemi takip edenler");
		userCem.getFollowing().forEach(System.out::println);
		System.out.println("Selimi takip edenler");
		userSelim.getFollowing().forEach(System.out::println);
		System.out.println("-----------------------------");

		BlogService blogService = new BlogService();

		Blog selimBlog = new Blog("What Are the New Features of SpringBoot3?",
				"The time is set for the 24th of this month", BlogType.DRAFT, null);
		Blog cemBlog = new Blog("Hayat Kurtaran Java Stream Komutlari",
				"Java 8 ile gelen en önemli ve günlük işlerimizi kolaylaştıran", BlogType.PUBLISHED, null);
		Blog merveBlog = new Blog("The Hidden Cost of High Salaries in Tech",
				"What is it, how you can start, and why it will make your", BlogType.PUBLISHED, null);
		Blog merveBlog2 = new Blog("What if failure is the plan?", "I’ve been thinking a lot about failure lately. ",
				BlogType.DRAFT, null);

		blogService.createBlog(selimBlog);
		blogService.createBlog(cemBlog);
		blogService.createBlog(merveBlog);
		blogService.createBlog(merveBlog2);

		selimBlog.setUser(userSelim);
		cemBlog.setUser(userCem);
		merveBlog.setUser(userMerve);
		merveBlog2.setUser(userMerve);

		userCem.setBlogs(List.of(cemBlog));
		userSelim.setBlogs(List.of(selimBlog));
		userMerve.setBlogs(List.of(merveBlog, merveBlog2));

		System.out.println("Merve uyesinin bloglari");
		blogService.printAll(blogService.getAllByUserName(userMerve));
		System.out.println("-----------------------------");

		userCem.setFollowedTags(List.of("Twitter", "Java"));
		System.out.println("Cem uyesinin takip ettigi tag");
		System.out.println(userCem.getFollowedTags());
		System.out.println("-----------------------------");

	}

}
