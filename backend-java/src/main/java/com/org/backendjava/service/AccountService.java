package com.org.backendjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.backendjava.model.dto.CreateAccountDTO;
import com.org.backendjava.model.dto.CreateAccountView;
import com.org.backendjava.model.entity.Account;
import com.org.backendjava.model.entity.User;
import com.org.backendjava.repository.AccountRepository;
import com.org.backendjava.service.interfaces.IAccountService;
import com.org.backendjava.service.interfaces.IUserService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class AccountService implements IAccountService {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private IUserService userService;
	
	@Transactional
	public CreateAccountView createAccount(CreateAccountDTO dto) {
		Account account = new Account(dto);
		validateCreateAccount(account);
		User user = userService.findById(account.getUser().getId());
		account.setUser(user);
		System.out.println(user.toString());
		account = accountRepository.save(account);
		CreateAccountView view = new CreateAccountView(account);
		return view;
	}
	
	public Account saveAccount(Account account) {
		return accountRepository.save(account);
	}
	
	public Account findByUser(User user) {
		return accountRepository.findByUser(user)
				.orElseThrow(() -> new EntityNotFoundException("user not found"));
	}
	
	private void validateCreateAccount(Account account) {
		if (account.getBalance().longValue() == 0)
			throw new RuntimeException("balance invalid");
	}
}
