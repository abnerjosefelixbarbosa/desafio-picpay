package com.org.backendjava.model.dto;

import org.hibernate.validator.constraints.Length;

import com.org.backendjava.annotation.Docment;
import com.org.backendjava.model.enums.TypeUser;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CreateWalletDTO(
		@NotNull(message = "nome completo invalido") @NotEmpty(message = "nome completo invalido") String fullNameUser,
		@NotNull(message = "documento invalido") @NotEmpty(message = "documento invalido") @Docment(message = "documento invalido") String docmentUser,
		@NotNull(message = "email invalido") @NotEmpty(message = "email invalido") @Email(message = "email invalido") String emailUser,
		@Length(min = 4, max = 4, message = "senha invalida") @NotNull(message = "senha invalida") @NotEmpty(message = "senha invalida") @Pattern(regexp = "^\\d+$", message = "senha invalida") String passwordUser,
		@NotNull(message = "tipo de usuario invalido") TypeUser typeUser) {
}