package emlakcepte.client;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;





@FeignClient(value = "emlakcepte-banner", url = "http://localhost:8081")
public interface BannerServiceClient {

	@PostMapping(value = "/banners")
	Banner create(@RequestBody Banner banner);

	@GetMapping(value="/banners")
	public ResponseEntity<String> getUsers();
	
	
}
