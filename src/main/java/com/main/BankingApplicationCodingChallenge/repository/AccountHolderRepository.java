package com.main.BankingApplicationCodingChallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.BankingApplicationCodingChallenge.model.AccountHolder;

public interface AccountHolderRepository extends JpaRepository<AccountHolder, Integer>{

}
