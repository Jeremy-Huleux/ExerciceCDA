package com.in28minutes.springboot.tutorial.basics.application.configuration.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.tutorial.basics.application.configuration.mapper.UserMapper;
import com.in28minutes.springboot.tutorial.basics.application.configuration.model.Token;
import com.in28minutes.springboot.tutorial.basics.application.configuration.model.User;
import com.in28minutes.springboot.tutorial.basics.application.configuration.service.impl.TokenService;
import com.in28minutes.springboot.tutorial.basics.application.configuration.utils.JwtUtil;
import com.in28minutes.springboot.tutorial.basics.application.configuration.utils.JwtValidator;

@RestController
@RequestMapping("/tokens")
public class TokenController {

	private JwtValidator jwtValidator = new JwtValidator();
	private JwtUtil jwtUtil = new JwtUtil();
	
	@Autowired
	private UserMapper usrMapper;

	@Autowired
	private TokenService tokenService;

	// TODO : ajouter spring security
	@PostMapping("/refresh-token")
	public ResponseEntity<String> refreshToken(@RequestBody Token refreshToken) {
		try {
			if (!jwtValidator.estExpirerToken(refreshToken.getToken())) {
				// regenere un token d'acces
				String newTokenDAcces = jwtUtil.generationTokenDAccesJwt(refreshToken.getUser().getUsername());
				return ResponseEntity.ok(newTokenDAcces);
			} else {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Token de rafraichissement expiré");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token de rafraichissement invalide");
		}
	}

	@GetMapping("/testoken")
	public Map<User, Token> afficherToken(){
		Map<User, Token> list = new HashMap<>();
		tokenService.getAllToken().forEach(token -> {
			list.put(token.getUser(), token);
		});
		return list;
	}

@PostMapping("/generateToken")
public boolean generationTokenByUser(@RequestBody User user) {

	try {
			//Gestion du problème de transiant Hibernate
			Token newToken = new Token();
			//On set le user dans le token
			newToken.setUser( 
				usrMapper.usernamToUserTransiant( //On map le user en user compatible Hibernate (transiant)
					user.getUsername() //via le user name recu
				).orElseThrow(() -> //Else pour les Optional<>
					new RuntimeException("User not found") // sinon on retourne une erreur
				)
			);

			newToken.setToken(jwtUtil.generationRefreshTokenJwtByObj(user)); //On génére un token de longue session (refresh token) et on le set dans l'objet
			tokenService.addToken(newToken); //Ajout dans la bdd
			return true;
	} catch (Exception e) {
		System.out.print(e.getMessage());
		return false;
	}
	
}


}
