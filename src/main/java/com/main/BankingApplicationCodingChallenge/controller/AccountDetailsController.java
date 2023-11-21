package com.main.BankingApplicationCodingChallenge.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.BankingApplicationCodingChallenge.dto.AccountDetailsDto;
import com.main.BankingApplicationCodingChallenge.exception.InvalidIdException;
import com.main.BankingApplicationCodingChallenge.model.Account;
import com.main.BankingApplicationCodingChallenge.model.AccountDetails;
import com.main.BankingApplicationCodingChallenge.model.AccountHolder;
import com.main.BankingApplicationCodingChallenge.model.BankExecutive;
import com.main.BankingApplicationCodingChallenge.service.AccountDetailsService;
import com.main.BankingApplicationCodingChallenge.service.AccountHolderService;
import com.main.BankingApplicationCodingChallenge.service.AccountService;
import com.main.BankingApplicationCodingChallenge.service.BankExecutiveService;

@RestController
@RequestMapping("/accountDetails")
public class AccountDetailsController {

	@Autowired
	private AccountDetailsService accountDetailsService;
	@Autowired
	private BankExecutiveService bankExecutiveService; 
	@Autowired
	private AccountHolderService accountHolderService; 
	@Autowired
	private AccountService accountService;
	
	
	@PostMapping("/add")
	public ResponseEntity<?> addaccountdetails(@RequestBody AccountDetailsDto accountDetailsDto) {
		try {
			
			int ahid =accountDetailsDto.getAccountHolderId();
			int aid = accountDetailsDto.getAccountId();
			int beid = accountDetailsDto.getBankExecutiveId();
			
			AccountDetails accountDetails = new AccountDetails();
			AccountHolder accountHolder= accountHolderService.getby(ahid);
			accountDetails.setAccountHolder(accountHolder);
			
			Account account = accountService.getById(aid);
			accountDetails.setAccount(account);
			
			BankExecutive executive = bankExecutiveService.getById(beid);
			accountDetails.setBankExecutive(executive);
			accountDetails.setDateOfCreation(LocalDate.now());
			accountDetails=accountDetailsService.add(accountDetails);
			
			return ResponseEntity.ok().body(accountDetails);
			
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
}
