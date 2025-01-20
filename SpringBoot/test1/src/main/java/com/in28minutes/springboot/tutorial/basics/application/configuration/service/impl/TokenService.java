package com.in28minutes.springboot.tutorial.basics.application.configuration.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.springboot.tutorial.basics.application.configuration.model.Token;
import com.in28minutes.springboot.tutorial.basics.application.configuration.repository.TokenRepository;
import com.in28minutes.springboot.tutorial.basics.application.configuration.service.ITokenService;

@Service
public class TokenService implements ITokenService {

	@Autowired
	private TokenRepository tokenRepo;

	@Override
	public Optional<Token> getTokenById(Long id){
		return tokenRepo.findById(id);
	}

	@Override
	public void deleteTokenById(Long id){
		tokenRepo.deleteById(id);
	}

	@Override
	public void deleteTokenByToken(Token token) {
		tokenRepo.delete(token);
	}

	@Override
	public void addToken(Token token) {
		tokenRepo.save(token);
	}

	@Override
	public void updateToken(Token token) {
		tokenRepo.save(token);
	}

	@Override
	public List<Token> getAllToken() {
		return tokenRepo.findAll();
	}

	

}
