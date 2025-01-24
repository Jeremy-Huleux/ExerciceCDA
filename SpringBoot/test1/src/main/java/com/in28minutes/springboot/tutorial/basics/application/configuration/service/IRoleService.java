package com.in28minutes.springboot.tutorial.basics.application.configuration.service;

import java.util.Set;

import com.in28minutes.springboot.tutorial.basics.application.configuration.model.Role;
import com.in28minutes.springboot.tutorial.basics.application.configuration.model.User;

public interface IRoleService {

	public void addRoleToUser (User user, Role role);
	public void addRolesToUser (User user, Set<Role> roles);
	public void deleteRoleToUser (User user, Role role);
	public void deleteAllRoleFromUser (User user, Set<Role> roles);
	public void updateRole(User user, Role roleModify, Role newRole);
	public Set<Role> getAllRolesFromUser (User user);
	public Set<Role> getAllRoles();
	public Set<User> getAllUsersFromRole(Role role);

}
