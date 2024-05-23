package com.org.backendjava.model.dto;

import com.org.backendjava.model.entity.TypeUser;

public record UserCreateDTO(
		//@NotNull(message = "full name invalid")
		//@NotEmpty(message = "full name invalid")
		String fullName,
		//@CPF(message = "cpf invalid")
		//@CNPJ(message = "cnpj invalid")
		String docment,
		//@NotNull(message = "email invalid")
		//@NotEmpty(message = "email name invalid")
		//@Email(message = "email invalid")
		String email,
		//@NotNull(message = "password invalid")
		//@NotEmpty(message = "password invalid")
		String password,
		//@NotNull(message = "type user invalid")
		//@NotEmpty(message = "type user invalid")
		TypeUser typeUser
) {}