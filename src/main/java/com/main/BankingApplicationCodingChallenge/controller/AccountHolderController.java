package com.main.BankingApplicationCodingChallenge.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.BankingApplicationCodingChallenge.model.AccountHolder;
import com.main.BankingApplicationCodingChallenge.service.AccountHolderService;

@RestController
@RequestMapping("/accountHolder")
public class AccountHolderController {
	@Autowired
	private AccountHolderService accountHolderservice;

	@PostMapping("/add")
	public AccountHolder addAccountHolder(@RequestBody AccountHolder accountHolder) {
		return accountHolderservice.addAccountHolder(accountHolder);
	}
	
	
}
