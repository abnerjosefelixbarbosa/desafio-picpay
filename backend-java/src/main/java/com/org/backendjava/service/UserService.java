package com.org.backendjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.org.backendjava.interfaces.IUserService;
import com.org.backendjava.model.dto.ListUserView;
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

	public User findById(Long id, String message) {
		return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(message));
	}

	public Page<ListUserView> listUser(Pageable pageable) {
		return userRepository.findAll(pageable).map(ListUserView::new);
	}

	public boolean existsByEmailOrDocmentOrPassword(User user) {
		return userRepository.existsByEmailOrDocmentOrPassword(user.getEmail(), user.getDocment(), user.getPassword());
	}
}
