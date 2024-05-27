package com.org.backendjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.backendjava.interfaces.IUserService;
import com.org.backendjava.model.dto.CreateUserDTO;
import com.org.backendjava.model.dto.CreateUserView;
import com.org.backendjava.model.entity.User;
import com.org.backendjava.repository.UserRepository;

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
		user = this.userRepository.save(user);
		CreateUserView view = new CreateUserView(user);
		return view;
	}
	
	public User findByIdOrDocment(Long id, String docment) {
		return userRepository.findByIdOrDocment(id, docment)
				.orElseThrow(() -> new EntityNotFoundException("id or docment not found"));
	}
	
	private void validateCreateUser(User user) {
		boolean result = false;
		result = userRepository.existsByEmailOrDocmentOrPassword(user.getEmail(), user.getDocment(), user.getPassword());
		if (result)
			throw new RuntimeException("email or docment or password exists");
	}
}