package com.org.backendjava.interfaces;

import com.org.backendjava.model.dto.CreateWalletDTO;
import com.org.backendjava.model.dto.CreateWalletView;

public interface IWalletService {
	CreateWalletView createWallet(CreateWalletDTO dto);
}