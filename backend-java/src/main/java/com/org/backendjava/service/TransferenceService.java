package com.org.backendjava.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.backendjava.model.dto.TransferenceDTO;
import com.org.backendjava.model.entity.Account;
import com.org.backendjava.model.entity.Transference;
import com.org.backendjava.model.entity.TypeUser;
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
	private IAccountService accountService;

	@Transactional
	public void transferValue(TransferenceDTO dto) {
		User payee = userService.findById(dto.payee());
		User payer = userService.findById(dto.payer());
		validateTransferValue(dto, payer);
		
		Account accountPayer = accountService.findByUser(payer);
		Account accountPayee = accountService.findByUser(payee);
		
		accountPayer.subtractBalance(dto.value());
		accountPayee.addBalance(dto.value());
		
		Transference transference = Transference.builder()
				.dateTime(LocalDateTime.now())
				.payee(payee)
				.payer(payer)
				.value(dto.value())
				.build();
		
		accountPayer = accountService.saveAccount(accountPayer);
		accountPayee = accountService.saveAccount(accountPayee);
		transference = transferenceRepository.save(transference);
		
		System.out.println(accountPayee.toString());
		System.out.println(accountPayer.toString());
		System.out.println(transference.toString());
	}
	
	public void validateTransferValue(TransferenceDTO dto, User payer) {
		if (dto.payee() == null) {
			throw new RuntimeException("payee invalid");
		}
        if (dto.payer() == null) {
        	throw new RuntimeException("payer invalid");
		}
		if (dto.value().longValue() == 0) {
			throw new RuntimeException("value invalid");
		}
		if (payer.getTypeUser() == TypeUser.SHOPKEEPER) {
			throw new RuntimeException("transference invalid");
		}
	}
	
	public Transference save(Transference transference) {
		return transferenceRepository.save(transference);
	}
}
