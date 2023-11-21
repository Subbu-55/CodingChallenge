package com.main.BankingApplicationCodingChallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.BankingApplicationCodingChallenge.model.AccountDetails;

public interface AccountDetailsRepository extends JpaRepository<AccountDetails, Integer>{

}
