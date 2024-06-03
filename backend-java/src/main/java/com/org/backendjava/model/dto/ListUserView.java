package com.org.backendjava.model.dto;

import com.org.backendjava.model.entity.User;
import com.org.backendjava.model.enums.TypeUser;

public record ListUserView(Long id, String fullName, String docment, String email, String password, TypeUser typeUser) {
	public ListUserView(User user) {
		this(user.getId(), user.getFullName(), user.getDocment(), user.getEmail(), user.getPassword(),
				user.getTypeUser());
	}
}