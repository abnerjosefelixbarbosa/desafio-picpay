package com.org.backendjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.org.backendjava.model.dto.CreateUserDTO;
import com.org.backendjava.model.dto.CreateUserView;
import com.org.backendjava.service.interfaces.IUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private IUserService userService; 
	
	@PostMapping("create-user")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<CreateUserView> createUser(@Valid @RequestBody CreateUserDTO dto) {
		CreateUserView view = userService.createUser(dto);
		return ResponseEntity.status(201).body(view);
	}
}