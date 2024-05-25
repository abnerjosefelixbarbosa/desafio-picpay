package com.org.backendjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.org.backendjava.model.dto.CreateAccountDTO;
import com.org.backendjava.model.dto.CreateAccountView;
import com.org.backendjava.service.interfaces.IAccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	@Autowired
	private IAccountService service; 
	
	@PostMapping("create-account")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<CreateAccountView> createAccount(@Valid @RequestBody CreateAccountDTO dto) {
		CreateAccountView view = service.createAccount(dto);
		return ResponseEntity.status(201).body(view);
	}
}
