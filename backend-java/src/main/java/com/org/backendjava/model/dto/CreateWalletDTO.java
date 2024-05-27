package com.org.backendjava.model.dto;

import java.math.BigDecimal;

import com.org.backendjava.annotation.Docment;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateWalletDTO(
		@NotNull(message = "balance invalid")
		BigDecimal balance,
		@NotNull(message = "user id invalid")
		Long userId,
		@NotEmpty(message = "user docment invalid")
		@NotNull(message = "user docment invalid")
		@Docment(message = "user docment invalid")
		String userDocment
) {}