package com.agilebis.test.assessmentDemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agilebis.test.assessmentDemo.exception.DBAuthenticationSecurityException;
import com.agilebis.test.assessmentDemo.model.dbrepository.DBUserRepository;
import com.agilebis.test.assessmentDemo.model.domain.DBUser;
import com.agilebis.test.assessmentDemo.service.contract.IDBUserService;

@Service
@Transactional
public class DBUserServiceImp implements IDBUserService, UserDetailsService {

	@Autowired
	DBUserRepository dbUserRepository;
	
	@Override
	public List<DBUser> getAllUsers() {
	
		return Optional.ofNullable(dbUserRepository.findAll())
				.orElse(new ArrayList<DBUser>());
	}

	@Override
	public DBUser getUserById(long userId) {
		
		return Optional.ofNullable(dbUserRepository.findByUserId(userId))
				.orElse(null);
	}

	@Override
	public DBUser getUserByUsername(String username) {
		return Optional.ofNullable(dbUserRepository.findByUsername(username))
				.orElse(null);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return getUserByUsername(username);
	}

	@Override
	public boolean isAuthenticated(String username, String password) {
		DBUser user= Optional.ofNullable(dbUserRepository.findByUsernameAndPassword(username, password))
					.orElse(null);
		if(user!=null) {
			if(user.isActive())
				return true;
			throw new DBAuthenticationSecurityException("Authentication Failure: User is found but with In Active status");
		}
		return false;
	}

}
