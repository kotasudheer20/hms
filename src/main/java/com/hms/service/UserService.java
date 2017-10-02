package com.hms.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.hms.dao.UserDao;
import com.hms.model.LoginUser;
import com.hms.model.User;

public class UserService {

	@Autowired
	private UserDao userDao;
	
	public User validateUser(LoginUser loginUser){
		return userDao.validateUser(loginUser);
	}
	
	public String registerUser(User user){
		return userDao.registerUser(user);
	}
}
