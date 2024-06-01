package com.org.backendjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.org.backendjava.interfaces.ITransferenceService;
import com.org.backendjava.model.dto.ListTransferencesView;
import com.org.backendjava.model.dto.TransferValueDTO;
import com.org.backendjava.model.dto.TransferValueView;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/transferences")
public class TransferenceController {
	@Autowired
	private ITransferenceService transferenceService;
	
	@PostMapping("/transfer-value")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<TransferValueView> transferValue(@Valid @RequestBody TransferValueDTO dto) {
		TransferValueView view = transferenceService.transferValue(dto);
		return ResponseEntity.status(200).body(view);
	}
	
	@GetMapping("/list-transference")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Page<ListTransferencesView>> listTransferencesByPayer(@RequestParam Long payer, Pageable pageable) {
		Page<ListTransferencesView> view = transferenceService.listTransferencesByPayer(payer, pageable);
		return ResponseEntity.status(200).body(view);
	}
}
