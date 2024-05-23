package com.org.backendjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.backendjava.model.entity.User;
import com.org.backendjava.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService implements IUserService {
	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public User findById(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("user not found"));
	}
}