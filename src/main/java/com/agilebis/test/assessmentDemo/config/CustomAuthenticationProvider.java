package com.agilebis.test.assessmentDemo.config;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.agilebis.test.assessmentDemo.exception.DBAuthenticationSecurityException;
import com.agilebis.test.assessmentDemo.model.domain.DBUser;
import com.agilebis.test.assessmentDemo.service.contract.IDBUserService;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	private Log log = LogFactory.getLog(CustomAuthenticationProvider.class);
	
	@Autowired
	IDBUserService dbUserService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userName = authentication.getName();
		String password = authentication.getCredentials().toString();
		boolean isLogedIn=dbUserService.isAuthenticated(userName, password);	
		if(!isLogedIn) 
			throw new DBAuthenticationSecurityException("Invalid Username or Password, Please try to login again with valid Credentials");
		DBUser userDetails = new DBUser();
		log.info("userName: " + userName+" is Logged In at: "+LocalDateTime.now());
		userDetails.setUsername(userName);
		userDetails.setPassword(password);
		List<GrantedAuthority> grantedAuths = new ArrayList<>();
		return new CustomUsernamePasswordAuthenticationToken(userDetails,password,grantedAuths);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}