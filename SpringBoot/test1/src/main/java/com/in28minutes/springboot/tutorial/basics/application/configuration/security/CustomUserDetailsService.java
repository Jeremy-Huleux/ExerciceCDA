package com.in28minutes.springboot.tutorial.basics.application.configuration.security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.in28minutes.springboot.tutorial.basics.application.configuration.model.User;
import com.in28minutes.springboot.tutorial.basics.application.configuration.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			User user = userRepo.findByUsername(username)
											.orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

			// COnvertis les rôles en autorités spring secu
			List<GrantedAuthority> authorities = user.getAllRoles().stream()
						.map(role -> new SimpleGrantedAuthority(role.getRole())) // on map l'objet role, on transforme la liste en role.getRole() (role::getRole)
						.collect(Collectors.toList());
						
		


		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'loadUserByUsername'");
	}

}
