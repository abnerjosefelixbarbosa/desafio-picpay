package com.org.backendjava.model.dto;

import java.math.BigDecimal;

import com.org.backendjava.model.entity.Wallet;

public record CreateWalletView(
		Long id,
		BigDecimal balance,
		Object user		
) {
	public CreateWalletView(Wallet obj) {
		this(obj.getId(), obj.getBalance(), obj.getUser());
	}
}