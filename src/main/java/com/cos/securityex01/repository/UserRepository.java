package com.cos.securityex01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cos.securityex01.model.User;

// CRUD 함수를 JpaRepository가 들고있음
// @Repository라는 어노테이션이 없어도 IOC됨. JpaRepository를 상속해서
// JpaRepository 를 상속하면 자동 컴포넌트 스캔됨. JpaRepository<User, PK타입>
public interface UserRepository extends JpaRepository<User, Integer>{
	
	// Jpa Query methods // findBy규칙 -> Username문법
	// SELECT * FROM user WHERE username = 1?
	User findByUsername(String username);
	
	// SELECT * FROM user WHERE username = 1? AND password = 2?
	// User findByUsernameAndPassword(String username, String password);
	
	// @Query(value = "select * from user", nativeQuery = true)
	// User find마음대로();
}
