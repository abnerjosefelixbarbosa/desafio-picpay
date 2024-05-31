package com.org.backendjava.model.dto;

import org.hibernate.validator.constraints.Length;

import com.org.backendjava.annotation.Docment;
import com.org.backendjava.model.enums.TypeUser;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateUserDTO(
		@NotNull(message = "nome completo invalido")
		@NotEmpty(message = "nome completo invalido")
		String fullName,
		@NotNull(message = "documento invalido")
		@NotEmpty(message = "documento invalido")
		@Docment(message = "documento invalido")
	    String docment,
	    @NotNull(message = "email invalido")
		@NotEmpty(message = "email invalido")
		@Email(message = "email invalido")
		String email,
		@Length(min = 4, max = 4, message = "senha invalida")
		@NotNull(message = "senha invalida")
		@NotEmpty(message = "senha invalida")
		String password,
		@NotNull(message = "tipo de usuario invalido")
		TypeUser typeUser
) {}