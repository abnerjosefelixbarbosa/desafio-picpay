package com.org.backendjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.org.backendjava.interfaces.IWalletService;
import com.org.backendjava.model.dto.CreateWalletDTO;
import com.org.backendjava.model.dto.CreateWalletView;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/accounts")
public class WalletController {
	@Autowired
	private IWalletService walletService; 
	
	@PostMapping("create-wallet")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<CreateWalletView> createWallet(@Valid @RequestBody CreateWalletDTO dto) {
		CreateWalletView view = walletService.createWallet(dto);
		return ResponseEntity.status(201).body(view);
	}
}
