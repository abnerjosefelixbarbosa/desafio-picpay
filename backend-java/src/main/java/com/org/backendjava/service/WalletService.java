package com.org.backendjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.backendjava.interfaces.IWalletService;
import com.org.backendjava.model.dto.CreateWalletDTO;
import com.org.backendjava.model.dto.CreateWalletView;
import com.org.backendjava.model.entity.User;
import com.org.backendjava.model.entity.Wallet;
import com.org.backendjava.repository.WalletRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class WalletService implements IWalletService {
	@Autowired
	private WalletRepository walletRepository;
	@Autowired
	private UserService userService;
	
	@Transactional
	public CreateWalletView createWallet(CreateWalletDTO dto) {
		Wallet wallet = new Wallet(dto);
		validateCreateWallet(wallet);
		User user = userService.findByIdOrDocment(dto.userId(), dto.userDocment());
		wallet.setUser(user);
		wallet = this.walletRepository.save(wallet);
		CreateWalletView view = new CreateWalletView(wallet);
		return view;
	}
	
	public Wallet findByUser(User user) {
		return walletRepository.findByUser(user)
				.orElseThrow(() -> new EntityNotFoundException("user not found"));
	}
	
	public Wallet saveWallet(Wallet wallet) {
		return walletRepository.save(wallet);
	}
	
	private void validateCreateWallet(Wallet wallet) {
		if (wallet.getBalance().scale() != 2)
			throw new RuntimeException("balance invalid");
	}
}
