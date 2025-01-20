package com.in28minutes.springboot.tutorial.basics.application.configuration.utils;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {


	private final SecretKey SECRET_KEY = Keys.hmacShaKeyFor("LaCleSecreteLaCleSecreteLaCleSecreteLaCleSecreteLaCleSecreteLaCleSecreteLaCleSecrete".getBytes());//génére un clé en 256 bits mini
	private final long EXPIRATION_TIME_ACCES = 15 * 60 * 1000; //15 minutes
	private final long EXPIRATION_TIME_REFRESH = 15 * 60 * 1000; //15 minutes


	//Création du token d'acces
	public String generationTokenDAccesJwt(String nomUtilisateur){
		return Jwts.builder()
									.setSubject(nomUtilisateur)
									.setIssuedAt(new Date()) //Ajoute la date de la création du token
									.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME_ACCES)) // Date d'expiration
									.signWith(SECRET_KEY)
									.compact();
	}
	//Création du token d'acces
	public String generationRefreshTokenJwt(String nomUtilisateur){
		return Jwts.builder()
									.setSubject(nomUtilisateur)
									.setIssuedAt(new Date()) //Ajoute la date de la création du token
									.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME_REFRESH)) // Date d'expiration
									.signWith(SECRET_KEY)
									.compact();
	}

	//Valider un token
	public boolean validateToken(String token){
		try{
			Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token); // vérifie le token
			return true;
		} catch (JwtException | IllegalArgumentException e) {
			return false; // Le token est périmé ou invalide
		}
	}

	public String extractNomUtilisateur(String token){
		return Jwts.parserBuilder()
									.setSigningKey(SECRET_KEY)
									.build()
									.parseClaimsJws(token)
									.getBody()
									.getSubject();
	}



	public SecretKey getKey(){
		return SECRET_KEY;
	}

}
