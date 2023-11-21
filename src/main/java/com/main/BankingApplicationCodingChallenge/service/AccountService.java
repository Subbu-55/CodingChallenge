package com.main.BankingApplicationCodingChallenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.BankingApplicationCodingChallenge.model.Account;
import com.main.BankingApplicationCodingChallenge.repository.AccountRepository;
import com.main.BankingApplicationCodingChallenge.exception.InvalidIdException;


@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;
	public Account addAccount(Account account) {
	
		return accountRepository.save(account);
	}
	public List<Account> findall(String type) {
		
		return accountRepository.findAll(type);
	}
	public Account getById(int aid) throws InvalidIdException{
		Optional<Account> optional = accountRepository.findById(aid);
		if(!optional.isPresent())
			throw new InvalidIdException("aid is not valid");
		return optional.get();
	}
	

}
