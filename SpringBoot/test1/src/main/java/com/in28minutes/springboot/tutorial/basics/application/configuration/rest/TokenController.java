package com.in28minutes.springboot.tutorial.basics.application.configuration.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.tutorial.basics.application.configuration.model.Token;
import com.in28minutes.springboot.tutorial.basics.application.configuration.service.impl.TokenService;
import com.in28minutes.springboot.tutorial.basics.application.configuration.utils.JwtUtil;
import com.in28minutes.springboot.tutorial.basics.application.configuration.utils.JwtValidator;

@RestController
@RequestMapping("/tokens")
public class TokenController {

	private JwtValidator jwtValidator = new JwtValidator();
	private JwtUtil jwtUtil = new JwtUtil();

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
	public List<Token> afficherToken(){
		return tokenService.getAllToken();
	}

}
