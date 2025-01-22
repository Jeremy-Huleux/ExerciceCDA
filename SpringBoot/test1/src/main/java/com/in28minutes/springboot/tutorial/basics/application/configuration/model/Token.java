package com.in28minutes.springboot.tutorial.basics.application.configuration.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="\"token\"")
public class Token {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"id\"")
	private Long id;

	@Column(name = "\"token\"")
	private String token;

	@Column(name= "\"deviceinfo\"")
	private String deviceInfo;

	@ManyToOne
	@JoinColumn(name="\"user_id\"")
	private User user;

	public Token(){
		super();
	}

	public Token(Long id, String token, User user) {
		this.id = id;
		this.token = token;
		this.user = user;
	}


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
