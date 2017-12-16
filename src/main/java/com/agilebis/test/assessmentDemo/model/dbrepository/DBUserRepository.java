package com.agilebis.test.assessmentDemo.model.dbrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agilebis.test.assessmentDemo.model.domain.DBUser;

@Repository
public interface DBUserRepository extends JpaRepository<DBUser, Long>{

	DBUser findByUsername(String username);
	DBUser findByUserId(long userId);
	DBUser findByUsernameAndPassword(String username, String password);
}
