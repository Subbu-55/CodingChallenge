package com.main.BankingApplicationCodingChallenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.BankingApplicationCodingChallenge.enums.Role;
import com.main.BankingApplicationCodingChallenge.model.BankExecutive;
import com.main.BankingApplicationCodingChallenge.model.User;
import com.main.BankingApplicationCodingChallenge.service.BankExecutiveService;
import com.main.BankingApplicationCodingChallenge.service.UserService;


@RestController
@RequestMapping("/bankExecutive")
public class BankExecutiveController {
	
	@Autowired
	private BankExecutiveService bankExecutiveService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/add")
	public BankExecutive addBankExecutive(@RequestBody BankExecutive bankExecutive) {
		User user=bankExecutive.getUser();
		
		user.setRole(Role.EXECUTIVE);
		user = userService.insert(user);
		bankExecutive.setUser(user);
		return bankExecutiveService.add(bankExecutive);
		
	}

}
