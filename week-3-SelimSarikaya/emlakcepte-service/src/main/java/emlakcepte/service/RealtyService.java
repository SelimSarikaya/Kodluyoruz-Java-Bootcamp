package emlakcepte.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlakcepte.client.Banner;
import emlakcepte.client.BannerServiceClient;
import emlakcepte.model.Realty;
import emlakcepte.model.RealtyState;
import emlakcepte.model.User;
import emlakcepte.model.enums.RealtyType;
import emlakcepte.model.enums.UserType;
import emlakcepte.repository.RealtyRepository;

@Service
public class RealtyService {

	@Autowired
	private RealtyRepository realtyDao;

	// @Autowired // injection
	// private UserService userService;

	@Autowired
	private BannerServiceClient bannerServiceClient;

	public void create(Realty realty) {

		// userService.printAllUser();

		/*
		 * if (UserType.INDIVIDUAL.equals(realty.getUser().getType())) { // en fazla 5
		 * ilan girebilir.
		 * 
		 * System.out.println("Bireysel kullanıclar en fazla 5 ilan girebilir."); }
		 */

		realtyDao.saveRealty(realty);
		System.out.println("createRealty :: " + realty);

		// TODO :: banner-service çağır ve banner siparişi ver

		Banner bannerRequest = new Banner(String.valueOf(realty.getNo()), 1, "123123", "");

		Banner bannerResponse = bannerServiceClient.create(bannerRequest);

		if (bannerResponse.getAdet() > 1) {
			System.out.println("hata verilsin");
		}

	}

	public List<Realty> getAll() {
		return realtyDao.findAll();
	}

	public void printAll(List<Realty> realtList) {
		realtList.forEach(realty -> System.out.println(realty));
	}

	public void getAllByProvince(String province) {

		getAll().stream().filter(realty -> realty.getProvince().equals(province))
				// .count();
				.forEach(realty -> System.out.println(realty));

	}

	public List<Realty> getAllByUserName(User user) {
		return getAll().stream().filter(realty -> realty.getUser().getMail().equals(user.getMail())).toList();
	}

	public List<Realty> getActiveRealtyByUserName(User user) {

		return getAll().stream().filter(realty -> realty.getUser().getName().equals(user.getName()))
				.filter(realty -> RealtyType.ACTIVE.equals(realty.getStatus())).toList();

	}

	// Şehir ve ilçe bazlı ilan arama
	public void getAllByProvinceDistrict(String province, String district) {
		getAll().stream()
				.filter(realty -> realty.getProvince().equals(province) && (realty.getDistrict().equals(district)))
				.forEach(realty -> System.out.println(realty));
	}

	public void searchListings(String keyword) {
		for (Realty listing : realtyDao.findAll()) {
			if (listing.toString().contains(keyword)) {
				System.out.println(listing);
			}
		}
	}

	// İllerde ki ilan sayısını bulma
	public void getProvinceRealtyCount(String province1, String province2, String province3) {
		long count1 = getAll().stream().filter(realty -> realty.getProvince().equals(province1)).count();
		long count2 = getAll().stream().filter(realty -> realty.getProvince().equals(province2)).count();
		long count3 = getAll().stream().filter(realty -> realty.getProvince().equals(province3)).count();
		System.out.println(count1 + count2 + count3);
	}

	// İllerdeki satılık ilan sayısını bulan
	public void getProvinceRealtySaleCount(String province1, String province2, String province3) {
		long count1 = getAll().stream().filter(t -> t.getProvince().equals(province1))
				.filter(y -> y.getState().equals(RealtyState.SALE)).count();
		long count2 = getAll().stream().filter(t -> t.getProvince().equals(province2))
				.filter(y -> y.getState().equals(RealtyState.SALE)).count();
		long count3 = getAll().stream().filter(t -> t.getProvince().equals(province3))
				.filter(y -> y.getState().equals(RealtyState.SALE)).count();
		System.out.println(count1 + count2 + count3);
	}

	// İl bazlı vitrin
	public void getShowcase(String province) {
		List<Realty> showCase = new ArrayList<>(10);
		showCase.addAll(getAll().stream().filter(realty -> realty.getProvince().equals(province)).toList());
		showCase.forEach(System.out::println);
	}

}
