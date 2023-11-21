package com.main.BankingApplicationCodingChallenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.BankingApplicationCodingChallenge.model.AccountDetails;
import com.main.BankingApplicationCodingChallenge.repository.AccountDetailsRepository;

@Service
public class AccountDetailsService {
	@Autowired
	private AccountDetailsRepository accountDetailsRepository;

	public AccountDetails add(AccountDetails accountDetails) {
		// TODO Auto-generated method stub
		return accountDetailsRepository.save(accountDetails);
	}

	

	

}
