package com.main.BankingApplicationCodingChallenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.BankingApplicationCodingChallenge.exception.InvalidIdException;
import com.main.BankingApplicationCodingChallenge.model.AccountHolder;
import com.main.BankingApplicationCodingChallenge.repository.AccountHolderRepository;

@Service
public class AccountHolderService {
	@Autowired
	private AccountHolderRepository accountHolderRepository;

	public AccountHolder addAccountHolder(AccountHolder accountHolder) {
		
		return accountHolderRepository.save(accountHolder);
	}

	public AccountHolder getby(int ahid) throws InvalidIdException{
		Optional<AccountHolder> optional = accountHolderRepository.findById(ahid);
		if(!optional.isPresent())
			throw new InvalidIdException("account holder id invalid");
		return optional.get();

	}

	

}
