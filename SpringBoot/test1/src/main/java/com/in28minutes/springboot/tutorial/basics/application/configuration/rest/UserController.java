package com.in28minutes.springboot.tutorial.basics.application.configuration.rest;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.tutorial.basics.application.configuration.model.Role;
import com.in28minutes.springboot.tutorial.basics.application.configuration.model.User;
import com.in28minutes.springboot.tutorial.basics.application.configuration.service.impl.RoleService;
import com.in28minutes.springboot.tutorial.basics.application.configuration.service.impl.UserService;




@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService usrService;
	@Autowired
	private RoleService roleService;
	@GetMapping("/allUsers")
	public List<User> getAllUsers() {
		return usrService.readUsers();
	}

	//TODO : test lien roles / users
	@PostMapping("/allRoles")
	public Set<Role> getAllRoles(@RequestBody User user) {
		return usrService.getAllRolesByUser(user);
	}
	@PostMapping("/allUserByRole")
	public Set<User> getAllUserByRole(@RequestBody Role role) {
		
		return roleService.getAllUsersFromRole(role);
	}

	// @GetMapping("/AllRoles")
	// public List<Role> getAllRoles() {
	// 	return roleService.getAllRoles();
	// }
	
	
}
