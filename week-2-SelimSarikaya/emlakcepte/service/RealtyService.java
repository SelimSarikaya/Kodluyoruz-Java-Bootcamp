package emlakcepte.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlakcepte.dao.RealtyDao;
import emlakcepte.model.Realty;
import emlakcepte.model.RealtyState;
import emlakcepte.model.RealtyType;
import emlakcepte.model.User;
import emlakcepte.model.UserType;

@Service
public class RealtyService {
	
	@Autowired
	private RealtyDao realtyDao;
	
	@Autowired //injection
	private UserService userService;
	
	public void createRealty(Realty realty) {	
		
		//userService.printAllUser();
		
		if (UserType.INDIVIDUAL.equals(realty.getUser().getType())) {

	/*		if(realty.getUser().getRealtyList().size() < 4) {   
				System.out.println("Bireysel kullanıclar en fazla 3 ilan girebilir.");
			} */
			
			
		}
			
		realtyDao.saveRealty(realty);
		System.out.println("createRealty :: " + realty.getTitle());
	}
	
	public List<Realty> getAll(){
		return realtyDao.findAll();
	}
	
	public void printAll(List<Realty> realtList) {
		realtList.forEach(realty -> System.out.println(realty));
	}

	public void getAllByProvince(String province) {
		
		getAll().stream()
		.filter(realty -> realty.getProvince().equals(province))
		//.count();
		.forEach(realty -> System.out.println(realty));
		
	}
	
	public List<Realty> getAllByUserName(User user){	
		return getAll().stream()
		.filter(realty -> realty.getUser().getMail().equals(user.getMail()))
		.toList();		
	}

	public List<Realty> getActiveRealtyByUserName(User user) {
		
		return getAll().stream()
		.filter(realty -> realty.getUser().getName().equals(user.getName()))
		.filter(realty -> RealtyType.ACTIVE.equals(realty.getStatus()))
		.toList();

	}
	
	public void getAllByProvinceDistrict(String province, String district) {   ////soru1
	getAll().stream().filter(realty -> realty.getProvince().equals(province) && (realty.getDistrict().equals(district)))
	.forEach(realty -> System.out.println(realty));
	}
	
	public void searchListings(String keyword) {
	    for (Realty listing : realtyDao.findAll()) {
	        if (listing.toString().contains(keyword)) {
	            System.out.println(listing);
	        }
	    }
	}
	
	public void getListingCount(String province) {
		long count = getAll().stream()
		.filter(realty -> realty.getProvince().equals(province)).count();
		System.out.println(count);
	}
	
	public List<Realty> getProvincesRealtyByStateSale (String province) {
		return getAll().stream()
		.filter(realty -> realty.getProvince().equals(province))//.forEach(t -> t.getState());
		.filter(realty -> RealtyState.SALE.equals(realty.getState())).toList();
		
	}
}
