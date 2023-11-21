package com.main.BankingApplicationCodingChallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.BankingApplicationCodingChallenge.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
