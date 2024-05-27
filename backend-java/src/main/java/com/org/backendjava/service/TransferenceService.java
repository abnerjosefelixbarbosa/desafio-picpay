package com.org.backendjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.backendjava.interfaces.ITransferenceService;
import com.org.backendjava.interfaces.IUserService;
import com.org.backendjava.interfaces.IWalletService;
import com.org.backendjava.model.dto.TransferenceDTO;
import com.org.backendjava.model.entity.Transference;
import com.org.backendjava.model.entity.User;
import com.org.backendjava.repository.TransferenceRepository;

import jakarta.transaction.Transactional;

@Service
public class TransferenceService implements ITransferenceService {
	@Autowired
	private TransferenceRepository transferenceRepository;
	@Autowired
	private IUserService userService;
	@Autowired
	private IWalletService walletService;

	@Transactional
	public void transferValue(TransferenceDTO dto) {
		
	}
	
	public void validateTransferValue(TransferenceDTO dto, User payer) {
		
	}
	
	public Transference save(Transference transference) {
		return transferenceRepository.save(transference);
	}
}
