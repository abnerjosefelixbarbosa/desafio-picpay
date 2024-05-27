package com.org.backendjava.model.dto;

public record TransferValueView(
		Object transference,
		Object walletPayee,
		Object walletPayer
) {}