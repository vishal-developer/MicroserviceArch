package com.pro.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ProfileController {

	@Autowired
	CBService cbService;
	
	@Value("${api_name:default profile}")
    private String profile;
	@RequestMapping(value = "/profile")
	public String getProfile(){
		
		return profile;
		
	}
	
	
	
	@RequestMapping("/profileSearch")
	public String search(){
		
	    return cbService.search();
	}
}
