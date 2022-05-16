package com.example.demo.restcontroller;

import java.util.List;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
	
	@Autowired  
	UserService userService;  

	@GetMapping("/user")  
	private List<User> getAllUser()   
	{  
	return userService.getAllUser();  
	}  
	@GetMapping("/user/{id}")  
	private User getUser(@PathVariable("id") int id)   
	{  
	return userService.getUserById(id);  
	}  
	@DeleteMapping("/userdelete/{id}")  
	private void deleteUser(@PathVariable("id") int id)   
	{  
	userService.deleteUserById(id);  
	}  
	@PostMapping("/usersave")  
	private long saveBook(@RequestBody User user)   
	{  
	userService.saveUser(user);  
	return user.getId();  
	}  
	@PutMapping("/userupdate")  
	private User update(@RequestBody User user)   
	{  
	userService.saveUser(user);  
	return user;  
	}  
	 

}
