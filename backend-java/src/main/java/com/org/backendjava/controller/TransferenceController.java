package com.org.backendjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.org.backendjava.interfaces.ITransferenceService;
import com.org.backendjava.model.dto.TransferenceDTO;

@RestController
@RequestMapping("/api/transferences")
public class TransferenceController {
	@Autowired
	private ITransferenceService transferenceService;
	
	@PostMapping("/transfer-value")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> transferValue(@RequestBody TransferenceDTO dto) {
		transferenceService.transferValue(dto);
		return ResponseEntity.status(200).body(null);
	}
}
