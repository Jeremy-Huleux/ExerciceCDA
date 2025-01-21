package com.in28minutes.springboot.tutorial.basics.application.configuration.mapper;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.tutorial.basics.application.configuration.model.User;
import com.in28minutes.springboot.tutorial.basics.application.configuration.service.impl.UserService;

@Component
public class UserMapper {

	@Autowired
	private UserService usrService;

	public Optional<User> usernamToUserTransiant(String userName){
		return usrService.findUserByUsername(userName);

	}

}
