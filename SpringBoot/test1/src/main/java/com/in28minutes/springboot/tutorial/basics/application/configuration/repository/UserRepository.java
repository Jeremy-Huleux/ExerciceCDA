package com.in28minutes.springboot.tutorial.basics.application.configuration.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.tutorial.basics.application.configuration.model.Role;
import com.in28minutes.springboot.tutorial.basics.application.configuration.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByUsername(String username);
	Set<User> findByRoles(Role role);
}
