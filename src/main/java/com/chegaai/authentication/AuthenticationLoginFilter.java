package com.chegaai.authentication;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AuthenticationLoginFilter extends AbstractAuthenticationProcessingFilter {

	public AuthenticationLoginFilter(String location, AuthenticationManager authenticationManager) {
		super(new AntPathRequestMatcher(location));
		setAuthenticationManager(authenticationManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {

		if(request.getMethod().equals("OPTIONS")) {
			response.addHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Headers", "Content-Type");
			return null;
		}

		AccountCredentials credentials = new ObjectMapper()
				.readValue(request.getInputStream(), AccountCredentials.class);
		
		return getAuthenticationManager().authenticate(
				new UsernamePasswordAuthenticationToken(
						credentials.getUsername(),
						credentials.getPassword(),
						new ArrayList<>()
				)
		);
		
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		
		ServletContext servletContext = request.getServletContext();
		WebApplicationContext webAppContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		AuthenticationService authenticationService =  webAppContext.getBean(AuthenticationService.class);
		
		Token token = authenticationService.createAuthenticationToken(authResult.getName());
		
		response.setStatus(HttpStatus.OK.value());
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().print(
				new ObjectMapper().writeValueAsString(token)
		);
		response.flushBuffer();
	}

}
