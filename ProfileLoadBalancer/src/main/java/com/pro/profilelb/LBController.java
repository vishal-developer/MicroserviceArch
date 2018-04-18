package com.pro.profilelb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LBController {
	
	
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/getFromLb")
	public String hi() {
	    return restTemplate.getForObject("http://profileService/profile", String.class);
	}

}
