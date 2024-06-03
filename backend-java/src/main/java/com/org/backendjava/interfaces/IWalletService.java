package com.org.backendjava.interfaces;

import com.org.backendjava.model.dto.CreateWalletDTO;
import com.org.backendjava.model.dto.CreateWalletView;
import com.org.backendjava.model.entity.User;
import com.org.backendjava.model.entity.Wallet;

public interface IWalletService {
	Wallet saveWallet(Wallet wallet);

	Wallet findByUser(User user, String message);

	CreateWalletView createWallet(CreateWalletDTO dto);
}