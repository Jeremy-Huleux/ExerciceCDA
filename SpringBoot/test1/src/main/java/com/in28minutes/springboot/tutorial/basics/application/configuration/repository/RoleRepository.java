package com.in28minutes.springboot.tutorial.basics.application.configuration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.tutorial.basics.application.configuration.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
