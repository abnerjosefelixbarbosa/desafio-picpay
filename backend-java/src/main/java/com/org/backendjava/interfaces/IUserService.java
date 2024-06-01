package com.org.backendjava.interfaces;

import com.org.backendjava.model.entity.User;

public interface IUserService {
	User saveUser(User user);
	User findById(Long id, String message);
	boolean existsByEmailOrDocmentOrPassword(User user);
}