package com.org.backendjava.interfaces;

import com.org.backendjava.model.dto.CreateWalletDTO;
import com.org.backendjava.model.dto.CreateWalletView;
import com.org.backendjava.model.entity.User;
import com.org.backendjava.model.entity.Wallet;

public interface IWalletService {
	CreateWalletView createWallet(CreateWalletDTO dto);
	Wallet findByUser(User user);
	Wallet saveWallet(Wallet wallet);
}