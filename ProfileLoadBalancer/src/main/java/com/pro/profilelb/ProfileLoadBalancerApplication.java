package com.pro.profilelb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RibbonClient(name = "profileService", configuration = ProfileServiceConfiguration.class)
public class ProfileLoadBalancerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfileLoadBalancerApplication.class, args);
	}
	
	@LoadBalanced
	@Bean
	public RestTemplate rest(RestTemplateBuilder builder) {
	    return builder.build();
	 }
}
