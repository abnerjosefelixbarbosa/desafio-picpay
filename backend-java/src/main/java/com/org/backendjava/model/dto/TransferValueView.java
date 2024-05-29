package com.org.backendjava.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.org.backendjava.model.entity.Transference;

public record TransferValueView(
		Long id,
		LocalDateTime dateTime,
		BigDecimal transferenceValue,
		Object payer,
		Object payee,
		BigDecimal payerBalance,
		BigDecimal payeeBalance
) {
	public TransferValueView(Transference transference,  BigDecimal payerBalance, BigDecimal payeeBalance) {
		this(
				transference.getId(),
				transference.getDateTime(),
				transference.getTransferenceValue(),
				transference.getPayer(),
				transference.getPayee(),
				payerBalance,
				payeeBalance
		);
	}
}