package com.org.backendjava.service.interfaces;

import com.org.backendjava.model.dto.CreateUserDTO;
import com.org.backendjava.model.dto.CreateUserView;
import com.org.backendjava.model.entity.User;

public interface IUserService {
	User saveUser(User user);
	User findById(Long id);
	CreateUserView createUser(CreateUserDTO dto);
}