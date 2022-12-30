package emlakcepte.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emlakcepte.model.Realty;
import emlakcepte.service.RealtyService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value = "/realtyes")
public class RealtyController {

	@Autowired
	private RealtyService realtyService;

	// GET /realtyes
	@GetMapping
	public List<Realty> getAll() {
		return realtyService.getAll();
	}

	// POST /realtyes
	@PostMapping
	public ResponseEntity<Realty> create(@RequestBody Realty realty) {
		System.out.println("realty" + realty);
		realtyService.create(realty);
		return new ResponseEntity<>(realty, HttpStatus.CREATED);
	}
	
	@GetMapping(value="/{province}/{district}")
	public void getAllByProvinceDistrict(@PathVariable("province") String province,@PathVariable("district") String district) {
		realtyService.getAllByProvinceDistrict(province, district);
	}
	
	@GetMapping(value="/{province}")
	public void getShocase(@RequestParam String province) {
		realtyService.getShowcase(province);
	}
	
	@GetMapping(value = "/{saleCount}")
	public void getProvinceRealtySaleCount(String province1, String province2, String province3) {
		realtyService.getProvinceRealtySaleCount(province1, province2, province3);
	}
	
	@GetMapping(value = "/{count}")
	public void getProvinceRealtyCount(String province1, String province2, String province3) {
		realtyService.getProvinceRealtyCount(province1, province2, province3);
	}
	@GetMapping(value = "/{listing}")
	public void searchListings(String keyword) {
		realtyService.searchListings(keyword);
	}
	

}
