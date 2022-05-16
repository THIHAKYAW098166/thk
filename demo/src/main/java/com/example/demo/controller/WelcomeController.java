package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {
	
	 
	 @Autowired
	    private UserService userService;

	 @RequestMapping(value = "/", method = RequestMethod.GET)
	    public String showWelcomePage() {
	        return "Welcome";
	    }
	 
	    @GetMapping("/listuser")
	    public String viewHomePage(Model model) {
	        model.addAttribute("listuser", userService.getAllUser());
	        return "list_user";
	    }

	    @GetMapping("/showNewUserForm")
	    public String showNewUserForm(Model model) {
	        User user = new User();
	        model.addAttribute("user", user);
	        return "new_user";
	    }

	    @PostMapping("/saveUser")
	    public String saveEmployee(@ModelAttribute("user") User user) {
	        userService.saveUser(user);
	        return "redirect:/";
	    }

	    @GetMapping("/showFormForUpdate/{id}")
	    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
	        User user = userService.getUserById(id);
	        model.addAttribute("user", user);
	        return "update_user";
	    }

	    @GetMapping("/deleteuser/{id}")
	    public String deleteUser(@PathVariable(value = "id") long id) {
	        this.userService.deleteUserById(id);
	        return "redirect:/";
	    }
	 
}
