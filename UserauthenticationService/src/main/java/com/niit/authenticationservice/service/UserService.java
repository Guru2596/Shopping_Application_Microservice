package com.niit.authenticationservice.service;

import java.util.List;

import com.niit.authenticationservice.exception.UserNotFoundException;
import com.niit.authenticationservice.model.User;

public interface UserService {

	public User registerUser(User user);
	public User findByUsernameAndPassword(String username,String password)throws UserNotFoundException;
	public List<User> getAllUsers();
}
