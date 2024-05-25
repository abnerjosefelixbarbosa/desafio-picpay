package com.org.backendjava.model.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateAccountDTO(
		@NotNull(message = "account invalid")
		@NotEmpty(message = "account invalid")
		String account,
		@NotNull(message = "agence invalid")
		@NotEmpty(message = "agence invalid")
		String agence,
		@NotNull(message = "balance invalid")
		@Digits(fraction = 2, integer = 38, message = "balance invalid")
		BigDecimal balance,
		@NotNull(message = "user invalid")
		Object user
) {}