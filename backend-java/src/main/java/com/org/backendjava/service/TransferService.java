package com.org.backendjava.service;

import org.springframework.stereotype.Service;

import com.org.backendjava.model.dto.TransferDTO;
import com.org.backendjava.repository.TransferRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransferService implements ITransferService {
	private final TransferRepository repository;

	public void transferValue(TransferDTO dto) {
		validateTransferValue(dto);
		System.out.println(dto.toString());
	}
	
	private void validateTransferValue(TransferDTO dto) {
		if (dto.value().longValue() == 0) {
			throw new RuntimeException("value invalid");
		}
		if (dto.payee().longValue() == 0) {
			throw new RuntimeException("payer invalid");
		}
		if (dto.payer().longValue() == 0) {
			throw new RuntimeException("payee invalid");
		}
	}
}
