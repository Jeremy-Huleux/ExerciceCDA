package com.in28minutes.springboot.tutorial.basics.application.configuration.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)//Ligne qui signifie que les données ne sont chargée que si necessaire (optimisation) (LAZY)
	@JoinTable(
		name = "user_roles",
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "roles_id")
	)
	@JsonIgnore
	private Set<Role> roles = new HashSet<>();
	
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

	public Set<Role> getAllRoles() {
		return this.roles;
	}

	public void setAllRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public void addRole(Role role) {
		this.roles.add(role);
	}

}
