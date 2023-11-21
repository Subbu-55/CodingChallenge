package com.main.BankingApplicationCodingChallenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.BankingApplicationCodingChallenge.dto.AccountDetailsDto;
import com.main.BankingApplicationCodingChallenge.dto.AccountDto;
import com.main.BankingApplicationCodingChallenge.exception.InvalidIdException;
import com.main.BankingApplicationCodingChallenge.model.Account;
import com.main.BankingApplicationCodingChallenge.model.AccountDetails;
import com.main.BankingApplicationCodingChallenge.model.AccountHolder;
import com.main.BankingApplicationCodingChallenge.service.AccountDetailsService;
import com.main.BankingApplicationCodingChallenge.service.AccountHolderService;
import com.main.BankingApplicationCodingChallenge.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	@Autowired
	private AccountHolderService accountHolderService;
	@Autowired
	private AccountDetailsService accountDetailsService;
	
	@PostMapping("/add")
	public Account insertAccount(@RequestBody Account account) {
		return accountService.addAccount(account);
	}
	@GetMapping("/getallAccounts/{type}")
	public List<Account> findallAccounts(@PathVariable String type){
		List<Account> list=accountService.findall(type);
		return list;
	}
	
	
	    
}
