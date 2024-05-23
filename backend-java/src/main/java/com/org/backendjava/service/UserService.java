package com.org.backendjava.service;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.backendjava.model.dto.UserCreateDTO;
import com.org.backendjava.model.dto.UserCreateView;
import com.org.backendjava.model.entity.TypeUser;
import com.org.backendjava.model.entity.User;
import com.org.backendjava.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class UserService implements IUserService {
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public UserCreateView createUser(UserCreateDTO dto) {
		User user = new User(dto);
		validateUser(user);
		//user = saveUser(user);
		UserCreateView view = new UserCreateView(user);
		return view;
	}
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public User findById(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("user not found"));
	}
	
    public void validateUser(User user) {
    	CPFValidator cpfValidator = new CPFValidator();
    	System.out.println(cpfValidator.isValid(user.getDocment(), null));
	}
}