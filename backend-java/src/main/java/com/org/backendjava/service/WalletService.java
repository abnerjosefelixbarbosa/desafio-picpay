package com.org.backendjava.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.backendjava.interfaces.IUserService;
import com.org.backendjava.interfaces.IWalletService;
import com.org.backendjava.model.dto.CreateWalletDTO;
import com.org.backendjava.model.dto.CreateWalletView;
import com.org.backendjava.model.entity.User;
import com.org.backendjava.model.entity.Wallet;
import com.org.backendjava.repository.WalletRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class WalletService implements IWalletService {
	@Autowired
	private WalletRepository walletRepository;
	@Autowired
	private IUserService userService;
	
	public CreateWalletView createWallet(CreateWalletDTO dto) {
		User user = new User(dto);
		Wallet wallet = new Wallet();
		
		validateCreateWallet(user);
		
		user = userService.saveUser(user);
		wallet.setBalance(BigDecimal.valueOf(0));
		wallet.setUser(user);
		wallet = walletRepository.save(wallet);
		
		CreateWalletView view = new CreateWalletView(wallet.getId(), wallet.getBalance(), user);
		
		return view;
	}
	
	public Wallet saveWallet(Wallet wallet) {
		return walletRepository.save(wallet);
	}

	public Wallet findByUser(User user, String message) {
		return walletRepository.findByUser(user)
				.orElseThrow(() -> new EntityNotFoundException(message));
	}
	
	private void validateCreateWallet(User user) {
		boolean response = userService.existsByEmailOrDocmentOrPassword(user);
		
		if (response)
			throw new RuntimeException("email, documento ou senha existem");
	}
}
