package com.org.backendjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.org.backendjava.model.dto.UserCreateDTO;
import com.org.backendjava.model.dto.UserCreateView;
import com.org.backendjava.service.IUserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private IUserService userService; 
	
	@PostMapping("create-user")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<UserCreateView> createUser(@RequestBody UserCreateDTO dto) {
		UserCreateView view = userService.createUser(dto);
		return ResponseEntity.status(201).body(view);
	}
}