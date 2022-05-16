package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;


public interface IUserService {
	
	 List<User> getAllUser();
	    void saveUser(User user);
	    User getUserById(long id);
	    void deleteUserById(long id);

}
