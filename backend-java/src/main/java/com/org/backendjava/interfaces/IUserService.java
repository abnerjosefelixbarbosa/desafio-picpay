package com.org.backendjava.interfaces;

import com.org.backendjava.model.dto.CreateUserDTO;
import com.org.backendjava.model.dto.CreateUserView;
import com.org.backendjava.model.entity.User;

public interface IUserService {
	CreateUserView createUser(CreateUserDTO dto);
	User findByIdOrDocment(Long id, String docment);
}