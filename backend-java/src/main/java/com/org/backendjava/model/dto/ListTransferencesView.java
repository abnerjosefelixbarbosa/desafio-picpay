package com.org.backendjava.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.org.backendjava.model.entity.Transference;

public record ListTransferencesView(LocalDateTime dateTime, BigDecimal transferenceValue, Object payer, Object payee) {
	public ListTransferencesView(Transference transference) {
		this(transference.getDateTime(), transference.getTransferenceValue(), transference.getPayer(),
				transference.getPayee());
	}
}
