package com.niit.authenticationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niit.authenticationservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUsernameAndPassword(String username, String password);

}
