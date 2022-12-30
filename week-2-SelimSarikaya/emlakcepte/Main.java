package emlakcepte;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import emlakcepte.model.Message;
import emlakcepte.model.Realty;
import emlakcepte.model.RealtyState;
import emlakcepte.model.RealtyType;
import emlakcepte.model.User;
import emlakcepte.model.UserType;
import emlakcepte.service.RealtyService;
import emlakcepte.service.UserService;

public class Main {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
		

		User userPelin = prepareUser("Pelin", "mimar.pelin@gmail.com", "Pelin123");
		User userSami = new User("Sami", "sami@gmail.com", "123", UserType.INDIVIDUAL, Collections.emptyList());

		/*
		 * UserService userService = UserService.getSameInstance();
		 * 
		 * UserService userService1 = UserService.getSameInstance();
		 * 
		 * UserService userService2 = UserService.getDifferentInstance();
		 * 
		 * System.out.println(userService); System.out.println(userService1);
		 * System.out.println(userService2);
		 */

		// eski yöntem
		//UserService userService = new UserService();

		//Spring bizim yerime create ediyor
		UserService userService = applicationContext.getBean(UserService.class);
		
		userService.createUser(userPelin);
		userService.createUser(userSami);

		userService.printAllUser();

		System.out.println("-----");

		// userList.add(user);
		// userList.add(userPelin);

		// userList.forEach(usr -> System.out.println(usr.getName()));

		RealtyService realtyService = new RealtyService();

		Realty realty = new Realty(123L, "ZEKERİYAKÖY ' de 1200 M2 Satılık VİLLA", LocalDateTime.now(), userPelin, RealtyType.ACTIVE, "Istanbul", "Zekariyakoy");
		realty.setProvince("İstanbul");

		realtyService.createRealty(realty);

		Realty realty1 = new Realty();
		realty1.setNo(124L);
		realty1.setTitle("Büyükdere Ana Cadde üstünde 16.060 m2 kapalı alanlı PLAZA");
		realty1.setStatus(RealtyType.ACTIVE);
		realty1.setUser(userPelin);
		realty1.setProvince("İstanbul");
		realty1.setState(RealtyState.LEASE);

		realtyService.createRealty(realty1);
		
		Realty realty2 = new Realty();
		realty2.setNo(124L);
		realty2.setTitle("Muhteşem Manzara Kaçırılmaz Fırsat");
		realty2.setStatus(RealtyType.ACTIVE);
		realty2.setUser(userPelin);
		realty2.setProvince("İzmir");
		realty2.setState(RealtyState.SALE);
		
		realtyService.createRealty(realty2);

		Realty favori1 = new Realty();
		favori1.setNo(125L);
		favori1.setTitle("KAVAKPINAR MAHALLESİNDE 2+1 80 M2 ARAKAT İSKANLI");
		favori1.setStatus(RealtyType.ACTIVE);
		favori1.setUser(userPelin);
		favori1.setProvince("Ankara");
		favori1.setState(RealtyState.SALE);

		realtyService.createRealty(favori1);

		realty.setUser(userSami);
		userSami.setRealtyList(List.of(realty, realty1));
		realty2.setUser(userPelin);

		List<Realty> fovarilerim = new ArrayList<>();
		fovarilerim.add(favori1);
		userSami.setFavoriteRealtyList(fovarilerim);

		// sistemdeki bütün ilanlar

		System.out.println("Bütün ilanlar");

		realtyService.printAll(realtyService.getAll());

		// İstanbuldaki ilanların bulunması

		System.out.println("İstanbul'daki ilanlar");

		realtyService.getAllByProvince("İstanbul");

		// Bir kullanıcının bütün ilanlarını listele
		realtyService.printAll(realtyService.getAllByUserName(userPelin));

		realtyService.printAll(realtyService.getActiveRealtyByUserName(userSami));

		/*
		 * userList.forEach(usr -> {
		 * 
		 * usr.getFavoriteRealtyList().forEach(favoriRealty ->
		 * System.out.println(favoriRealty.getTitle()) );
		 * 
		 * });
		 */

		Message message = new Message("acil dönüş", "ilan ile ilgili bilgilendirme verebilir misiniz?", userPelin,
				userSami);

		userSami.setMessages(List.of(message));
		userPelin.setMessages(List.of(message));

		userSami.getMessages();
		System.out.println("------------------------");
		realtyService.searchListings("Büyükdere");
		
		userService.saveSearch("Büyükdere", userSami);
		System.out.println("------------------------");
		userService.listSearch(userSami);
		 	
		System.out.println("------------------------");
		realtyService.getListingCount("İstanbul");
		
		System.out.println("------------------------");
		System.out.println(	realtyService.getProvincesRealtyByStateSale("Ankara"));
		realtyService.getProvincesRealtyByStateSale("Ankara");
		
		System.out.println("------------------------");
		


	
		

	}

	private static User prepareUser(String name, String email, String password) {
		User user = new User();
		user.setName(name);
		user.setMail(email);
		user.setPassword(password);
		user.setType(UserType.INDIVIDUAL);
		user.setCreateDate(LocalDateTime.now());
		return user;
	}

}
