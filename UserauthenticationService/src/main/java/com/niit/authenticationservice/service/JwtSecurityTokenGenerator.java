package com.niit.authenticationservice.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.niit.authenticationservice.model.User;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtSecurityTokenGenerator implements SecurityTokenGenerator{

	@Override
	public Map<String, String> generateToken(User user) {
		
		String jsonWebToken = null;
		
		JwtBuilder jwtBuilder = Jwts.builder();
		jsonWebToken = jwtBuilder.setSubject(user.getUsername()).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secret").compact();
		
		Map<String, String> tokenMap = new HashMap<String, String>();
		tokenMap.put("token", jsonWebToken);
		tokenMap.put("message", "User Successfully Logged In...!");
		
		return tokenMap;
	}

}
