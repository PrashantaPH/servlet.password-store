package com.ty.password.store.service;

import com.ty.password.store.dao.UserDao;
import com.ty.password.store.dto.User;

public class UserService {

	UserDao dao = new UserDao();

	public User saveUser(User user) {
		
		return dao.saveUser(user);
	}
	public User validateUser(String email,String paasword)
	{
		return  dao.validateUser(email, paasword);
	}
}
