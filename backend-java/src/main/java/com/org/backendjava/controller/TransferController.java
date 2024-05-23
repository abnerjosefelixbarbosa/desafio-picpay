package com.org.backendjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.org.backendjava.model.dto.TransferenceDTO;
import com.org.backendjava.service.ITransferenceService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/transfer")
public class TransferController {
	@Autowired
	private ITransferenceService service;
	
	@PostMapping("/transfer-value")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Void> transferValue(@Valid @RequestBody TransferenceDTO dto) {
		service.transferValue(dto);
		return ResponseEntity.status(204).body(null);
	}
}
