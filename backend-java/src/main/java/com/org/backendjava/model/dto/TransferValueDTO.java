package com.org.backendjava.model.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;

public record TransferValueDTO(
		@NotNull(message = "value invalid")
		BigDecimal value,
		@NotNull(message = "payer invalid")
		Long payer,
		@NotNull(message = "payee invalid")
		Long payee
) {}