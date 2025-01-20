package com.in28minutes.springboot.tutorial.basics.application.configuration.service;

import java.util.List;
import java.util.Optional;

import com.in28minutes.springboot.tutorial.basics.application.configuration.model.Token;


public interface ITokenService {

	Optional<Token> getTokenById(Long id);
	void deleteTokenById(Long id);
	void deleteTokenByToken(Token token);
	void addToken(Token token);
	void updateToken(Token token);
	List<Token> getAllToken();
}
