package com.agilebis.test.assessmentDemo.config;

import java.util.Collection;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import com.agilebis.test.assessmentDemo.model.domain.DBUser;


public class CustomUsernamePasswordAuthenticationToken extends UsernamePasswordAuthenticationToken{

	private static final long serialVersionUID = 1L;
	private DBUser dBUser = new DBUser();

	public CustomUsernamePasswordAuthenticationToken(Object principal, Object credentials,Collection<? extends GrantedAuthority> authorities) {
		super(principal, credentials, authorities);
		this.dBUser =(DBUser)principal;
	}

	public DBUser getDBUser() {

		return dBUser;
	}
}
