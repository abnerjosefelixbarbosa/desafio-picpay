package com.org.backendjava.model.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;

public record TransferValueDTO(
		@NotNull(message = "valor invalido")
		BigDecimal value,
		@NotNull(message = "pagador invalido")
		Long payer,
		@NotNull(message = "benefíciario invalido")
		Long payee
) {}