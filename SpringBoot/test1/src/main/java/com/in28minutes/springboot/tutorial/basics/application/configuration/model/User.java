package com.in28minutes.springboot.tutorial.basics.application.configuration.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "\"user\"")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="\"id\"")
	private Long id;

	@Column(name="\"username\"")
	private String username;

	@Column(name="\"password\"")
	private String password;

	public User(){
		super();
	}
	
	public User(Long id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
