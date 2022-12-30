package emlakcepte.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import emlakcepte.model.Realty;
@Repository
public class RealtyDao {
	
	private static List<Realty> realtyList = new ArrayList<>();
	
	public void saveRealty(Realty realty) {
		realtyList.add(realty);
	}
	
	public List<Realty> findAll(){
		return realtyList;
	}

}
