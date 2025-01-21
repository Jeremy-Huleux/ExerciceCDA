package com.in28minutes.springboot.tutorial.basics.application.configuration.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.springboot.tutorial.basics.application.configuration.model.User;
import com.in28minutes.springboot.tutorial.basics.application.configuration.repository.UserRepository;
import com.in28minutes.springboot.tutorial.basics.application.configuration.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository usrRepo;


// public UserService(UserRepository usrRepo){
// 	this.usrRepo = usrRepo;
// }

	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'createUser'");
	}

	@Override
	public List<User> readUsers() {
		return usrRepo.findAll();
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
	}

	@Override
	public Optional<User> findUserById(Long id) {
		return usrRepo.findById(id);
	}

	@Override
	public Optional<User> findUserByUsername(String username) {
		// return usrRepo.findByUsername(username);
		return usrRepo.findById(2L);
	}

}
