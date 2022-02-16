package com.niit.authenticationservice.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JwtFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request1=(HttpServletRequest)request;
		HttpServletResponse response1=(HttpServletResponse)response;
		
		String authenticationHeader=request1.getHeader("authorization");
		
		if(request1.getMethod().equals("OPTIONS"))
		{
			response1.setStatus(HttpServletResponse.SC_OK);
			chain.doFilter(request1, response1);
		}
		else
		{
			if(authenticationHeader==null||!authenticationHeader.startsWith("Bearer"))
				throw new ServletException("Missing or Invalid Authorization Header");
		}
		
		final String token=authenticationHeader.substring(7);
		Claims claims=Jwts.parser().setSigningKey("secret").parseClaimsJws(token).getBody();
		request1.setAttribute("claims", claims);
		chain.doFilter(request1, response1);

	}

}
