package com.org.backendjava.model.dto;

import com.org.backendjava.annotation.Docment;
import com.org.backendjava.model.enums.TypeUser;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateUserDTO(
		@NotNull(message = "full name invalid")
		@NotEmpty(message = "full name invalid")
		String fullName,
		@NotNull(message = "document invalid")
		@NotEmpty(message = "document invalid")
		@Docment(message = "document invalid")
		String docment,
		@NotNull(message = "email invalid")
		@NotEmpty(message = "email name invalid")
		@Email(message = "email invalid")
		String email,
		@NotNull(message = "password invalid")
		@NotEmpty(message = "password invalid")
		String password,
		@NotNull(message = "type user invalid")
		TypeUser typeUser
) {}