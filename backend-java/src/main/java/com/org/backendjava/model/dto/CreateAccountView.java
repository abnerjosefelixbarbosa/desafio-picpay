package com.org.backendjava.model.dto;

import java.math.BigDecimal;

import com.org.backendjava.model.entity.Account;

public record CreateAccountView(
		Long id,
		String account,
		String agence,
		BigDecimal balance,
		Object user		
) {
	public CreateAccountView(Account obj) {
		this(obj.getId(), obj.getAccount(), obj.getAgence(), obj.getBalance(), obj.getUser());
	}
}