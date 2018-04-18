package com.pro.profile;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CBService {

	@Autowired
	RestTemplate restTemplate;

	  public CBService(RestTemplate rest) {
	    this.restTemplate = rest;
	  }

	  @HystrixCommand(fallbackMethod = "reliable")
	  public String search() {
	    URI uri = URI.create("http://localhost:8081/search");
	    return this.restTemplate.getForObject(uri, String.class);
	  }

	  
	  public String reliable() {
	    return "Default Service by Hystrix";
	  }
}
