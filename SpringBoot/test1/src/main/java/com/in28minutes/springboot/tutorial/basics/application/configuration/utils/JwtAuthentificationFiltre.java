package com.in28minutes.springboot.tutorial.basics.application.configuration.utils;


import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthentificationFiltre extends HttpFilter{

	private JwtValidator jwtValidator;

	@Override
	protected void doFilter(HttpServletRequest requette, HttpServletResponse reponse, FilterChain chaine)
		throws IOException, ServletException{

		//On récupére l'entete 
		String authorisationHeader = requette.getHeader("Authorization");

			if(authorisationHeader != null && authorisationHeader.startsWith("Bearer ")){
				String token = authorisationHeader.substring(7); // on retirer le bearer du header
				try {
						String username = jwtValidator.validationEtRecupUtilisateur(token);

						System.out.println("Utilisateur du token : " + username);

				} catch (Exception e) {
					reponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
					
				}
			}
		}
}


