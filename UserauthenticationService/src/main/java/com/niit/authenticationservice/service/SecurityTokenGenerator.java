package com.niit.authenticationservice.service;

import java.util.Map;

import com.niit.authenticationservice.model.User;

public interface SecurityTokenGenerator {

	Map<String,String> generateToken(User user);
}
