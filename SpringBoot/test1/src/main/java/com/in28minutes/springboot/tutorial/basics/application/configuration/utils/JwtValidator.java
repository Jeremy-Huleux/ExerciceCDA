package com.in28minutes.springboot.tutorial.basics.application.configuration.utils;

import java.util.Date;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JwtValidator {

	private JwtUtil jwtUtil = new JwtUtil();
	private final SecretKey SECRET_KEY = jwtUtil.getKey();//Keys.hmacShaKeyFor("LaCleSecreteLaCleSecreteLaCleSecreteLaCleSecreteLaCleSecreteLaCleSecreteLaCleSecrete".getBytes());//génére un clé en 256 bits mini

	// Valider et décoder le token
	public Claims validationEtRecupClaims(String token){
		try {
			return Jwts.parserBuilder()
										.setSigningKey(SECRET_KEY)
										.build()
										.parseClaimsJws(token) //fonction qui valide ET parse le token
										.getBody(); //Récupére les claims
		} catch (Exception e) {
			throw new RuntimeException("Token invalide ou expiré.", e);
		}
	}

	public String validationEtRecupUtilisateur(String token){
		try {
			return Jwts.parserBuilder()
										.setSigningKey(SECRET_KEY)
										.build()
										.parseClaimsJws(token) //fonction qui valide ET parse le token
										.getBody() //le corps
										.getSubject(); //Retourne le sujet (le nom d'utilisateur)
		} catch (Exception e) {
			throw new RuntimeException("Token invalide ou expiré.", e);
		}
	}

	public boolean estExpirerToken(String token){
		Claims claim = Jwts.parserBuilder()
											.setSigningKey(SECRET_KEY)
											.build()
											.parseClaimsJws(token)
											.getBody();
		Date dateExpiration = claim.getExpiration();//on recup la date d'expiration du token
		return dateExpiration.before(new Date());//fonction dans les date qui retourne true or false si la date en parametre est avant la date de la variable
									
	}

}
