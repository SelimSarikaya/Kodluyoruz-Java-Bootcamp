package com.emlakcepte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.emlakcepte.model.Banner;
import com.emlakcepte.service.BannerService;

@RestController
@RequestMapping(value = "/banners") 
public class BannerController {

	@Autowired
	private BannerService bannerService;
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/users")
	public ResponseEntity<String> getUsers() {
	    String url = "http://localhost:8080/users";
	    return restTemplate.getForEntity(url, String.class);
	}
	


	
	

}
