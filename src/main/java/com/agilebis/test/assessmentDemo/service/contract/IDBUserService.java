package com.agilebis.test.assessmentDemo.service.contract;

import java.util.List;

import com.agilebis.test.assessmentDemo.model.domain.DBUser;

public interface IDBUserService {

	List<DBUser> getAllUsers();
	DBUser getUserById(long userId);
	DBUser getUserByUsername(String username);
	boolean isAuthenticated(String username, String password);
	
}
