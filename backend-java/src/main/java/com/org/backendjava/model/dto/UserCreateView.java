package com.org.backendjava.model.dto;

import com.org.backendjava.model.entity.TypeUser;
import com.org.backendjava.model.entity.User;

public record UserCreateView(
		Long id,
		String fullName,
		String docment,
		String email,
		String password,
		TypeUser typeUser
) {
	public UserCreateView(User user) {
		this(
			user.getId(),
			user.getFullName(),
			user.getDocment(),
			user.getEmail(),
			user.getPassword(),
			user.getTypeUser()
		);
	}
}