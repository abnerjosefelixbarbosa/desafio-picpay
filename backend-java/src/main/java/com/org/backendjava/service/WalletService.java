package com.org.backendjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.backendjava.interfaces.IWalletService;
import com.org.backendjava.model.entity.User;
import com.org.backendjava.model.entity.Wallet;
import com.org.backendjava.repository.WalletRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class WalletService implements IWalletService {
	@Autowired
	private WalletRepository walletRepository;
	
	public Wallet saveWallet(Wallet wallet) {
		return walletRepository.save(wallet);
	}

	public Wallet findByUser(User user, String message) {
		return walletRepository.findByUser(user)
				.orElseThrow(() -> new EntityNotFoundException(message));
	}
}
