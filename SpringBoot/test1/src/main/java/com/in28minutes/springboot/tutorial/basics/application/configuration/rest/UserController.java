package com.in28minutes.springboot.tutorial.basics.application.configuration.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.tutorial.basics.application.configuration.model.User;
import com.in28minutes.springboot.tutorial.basics.application.configuration.service.impl.UserService;


@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService usrService;
	@GetMapping("/allUsers")
	public List<User> getAllUsers() {
		return usrService.readUsers();
	}
	
}
