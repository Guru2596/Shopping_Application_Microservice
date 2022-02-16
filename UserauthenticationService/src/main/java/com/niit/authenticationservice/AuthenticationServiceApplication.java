package com.niit.authenticationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.niit.authenticationservice.filter.JwtFilter;

@SpringBootApplication
public class AuthenticationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationServiceApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<JwtFilter> jwtFilter()
	{
		FilterRegistrationBean<JwtFilter> filterBean=new FilterRegistrationBean<JwtFilter>();
		filterBean.setFilter(new JwtFilter());
		filterBean.addUrlPatterns("/api/v1/userdetails/*");
		return filterBean;
	}
}
