package com.org.backendjava.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.org.backendjava.model.dto.TransferDTO;
import com.org.backendjava.service.ITransferService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/transfer")
@AllArgsConstructor
public class TransferController {
	private final ITransferService service;
	
	@PostMapping("/transfer-value")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Void> transferValue(@Valid @RequestBody TransferDTO dto) {
		service.transferValue(dto);
		return ResponseEntity.status(204).body(null);
	}
}
