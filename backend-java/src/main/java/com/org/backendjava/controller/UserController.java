package com.org.backendjava.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.backendjava.model.dto.CreateUserDTO;
import com.org.backendjava.model.dto.CreateUserView;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@PostMapping("/create-user")
	public ResponseEntity<CreateUserView> createUser(@Valid @RequestBody CreateUserDTO dto) {
		return ResponseEntity.status(201).body(null);
	}
}
