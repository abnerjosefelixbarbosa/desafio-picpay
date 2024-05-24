package com.org.backendjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.backendjava.model.entity.Account;
import com.org.backendjava.model.entity.User;
import com.org.backendjava.repository.AccountRepository;
import com.org.backendjava.service.interfaces.IAccountService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AccountService implements IAccountService {
	@Autowired
	private AccountRepository accountRepository;
	
	public Account saveAccount(Account account) {
		return accountRepository.save(account);
	}
	
	public Account findByUser(User user) {
		return accountRepository.findByUser(user)
				.orElseThrow(() -> new EntityNotFoundException("user not found"));
	}
}
