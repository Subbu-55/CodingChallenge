package com.main.BankingApplicationCodingChallenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.BankingApplicationCodingChallenge.model.User;
import com.main.BankingApplicationCodingChallenge.repository.UserRepository;
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User insert(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

}
