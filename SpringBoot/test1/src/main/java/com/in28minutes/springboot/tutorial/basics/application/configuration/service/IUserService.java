package com.in28minutes.springboot.tutorial.basics.application.configuration.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.in28minutes.springboot.tutorial.basics.application.configuration.model.Role;
import com.in28minutes.springboot.tutorial.basics.application.configuration.model.User;

public interface IUserService {

	void createUser(User user);
	List<User> readUsers();
	void updateUser(User user);
	void deleteUser(User user);
	Optional<User> findUserById(Long id);
	Optional<User> findUserByUsername(String username);
	void addRoleToUser(User user, Role role);
	void addRoleToUserStringProperty(String user, String role);
	Set<Role> getAllRolesByUser(User user);

}
