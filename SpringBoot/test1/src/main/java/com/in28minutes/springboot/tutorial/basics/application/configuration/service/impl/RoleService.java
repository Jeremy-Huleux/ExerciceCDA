package com.in28minutes.springboot.tutorial.basics.application.configuration.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.springboot.tutorial.basics.application.configuration.model.Role;
import com.in28minutes.springboot.tutorial.basics.application.configuration.model.User;
import com.in28minutes.springboot.tutorial.basics.application.configuration.repository.RoleRepository;
import com.in28minutes.springboot.tutorial.basics.application.configuration.repository.UserRepository;
import com.in28minutes.springboot.tutorial.basics.application.configuration.service.IRoleService;

@Service
public class RoleService implements IRoleService {

	@Autowired
	private RoleRepository roleRepo;

	@Autowired
	private UserRepository usrRepo;


	@Override
	public void addRoleToUser(User user, Role role) {
		
		roleRepo.save(role);
	}

	@Override
	public void addRolesToUser(User user, Set<Role> roles) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'addRolesToUser'");
	}

	@Override
	public void deleteRoleToUser(User user, Role role) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deleteRoleToUser'");
	}

	@Override
	public void deleteAllRoleFromUser(User user, Set<Role> roles) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deleteAllRoleFromUser'");
	}

	@Override
	public void updateRole(User user, Role roleModify, Role newRole) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'updateRole'");
	}

	@Override
	public Set<Role> getAllRolesFromUser(User user) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getAllRolesFromUser'");
	}

	@Override
	public Set<Role> getAllRoles() {
		Set<Role> newSetRoles = new HashSet<>();
		newSetRoles.addAll(roleRepo.findAll());
		return newSetRoles;
	}

	@Override
	public Set<User> getAllUsersFromRole(Role role) {
		System.out.println(role.getRole());
		Role roleTrouve = roleRepo.findByRole(role.getRole())
									.orElseThrow(() -> new RuntimeException("Role non trouvé"));
		return usrRepo.findByRoles(roleTrouve);
	}

	// @Override
	// public Set<Role> getAllRolesFromRolename(String role) {
	// 	Set<Role> roles = new HashSet<>();
	// 	//List<User> users = usrRepo.

	// }

}
