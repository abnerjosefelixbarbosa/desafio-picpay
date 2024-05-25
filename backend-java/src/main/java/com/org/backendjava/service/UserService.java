package com.org.backendjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.backendjava.model.dto.CreateUserDTO;
import com.org.backendjava.model.dto.CreateUserView;
import com.org.backendjava.model.entity.User;
import com.org.backendjava.repository.UserRepository;
import com.org.backendjava.service.interfaces.IUserService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class UserService implements IUserService {
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public CreateUserView createUser(CreateUserDTO dto) {
		User user = new User(dto);
		validateCreateUser(user);
		user = saveUser(user);
		CreateUserView view = new CreateUserView(user);
		return view;
	}
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public User findById(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("user not found"));
	}
	
	private void validateCreateUser(User user) {
		boolean result = false;
		result = userRepository.existsByEmail(user.getEmail());
		if (result)
			throw new RuntimeException("email exists");
		result = userRepository.existsByDocment(user.getDocment());
		if (result)
			throw new RuntimeException("docment exists");
		result = userRepository.existsByPassword(user.getPassword());
		if (result)
		    throw new RuntimeException("password exists");
		
	}
}