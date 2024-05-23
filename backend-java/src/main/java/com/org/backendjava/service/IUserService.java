package com.org.backendjava.service;

import com.org.backendjava.model.dto.UserCreateDTO;
import com.org.backendjava.model.dto.UserCreateView;
import com.org.backendjava.model.entity.User;

public interface IUserService {
	User saveUser(User user);
	User findById(Long id);
	UserCreateView createUser(UserCreateDTO dto);
	void validateUser(User user);
}