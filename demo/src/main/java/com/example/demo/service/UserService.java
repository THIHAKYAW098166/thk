package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
	
	
	 @Autowired
	    private UserRepository userRepository;

	    @Override
	    public List<User> getAllUser() {
	        return userRepository.findAll();
	    }

	    @Override
	    public void saveUser(User user) {
	        this.userRepository.save(user);
	    }

	    @Override
	    public User getUserById(long id) {
	        Optional < User > optional = userRepository.findById(id);
	        User user = null;
	        if (optional.isPresent()) {
	            user = optional.get();
	        } else {
	            throw new RuntimeException(" Employee not found for id :: " + id);
	        }
	        return user;
	    }

	    @Override
	    public void deleteUserById(long id) {
	        this.userRepository.deleteById(id);
	    }

}
