package com.org.backendjava.service;

import com.org.backendjava.model.entity.User;

public interface IUserService {
	User saveUser(User user);
	User findById(Long id);
}