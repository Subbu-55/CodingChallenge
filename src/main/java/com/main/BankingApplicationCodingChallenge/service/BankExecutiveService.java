package com.main.BankingApplicationCodingChallenge.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.BankingApplicationCodingChallenge.exception.InvalidIdException;
import com.main.BankingApplicationCodingChallenge.model.AccountHolder;
import com.main.BankingApplicationCodingChallenge.model.BankExecutive;
import com.main.BankingApplicationCodingChallenge.repository.BankExecutiveRepository;

@Service
public class BankExecutiveService {

	@Autowired
	private BankExecutiveRepository bankExecutiveRepository;
	
	public BankExecutive add(BankExecutive bankExecutive) {
		// TODO Auto-generated method stub
		return bankExecutiveRepository.save(bankExecutive);
	}

	public BankExecutive getById(int beid) throws InvalidIdException{
		Optional<BankExecutive> optional = bankExecutiveRepository.findById(beid);
		if(!optional.isPresent())
			throw new InvalidIdException("BankExecutive id invalid");
		return optional.get();

	}

}
