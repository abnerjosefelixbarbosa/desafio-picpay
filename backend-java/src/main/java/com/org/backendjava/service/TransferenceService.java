package com.org.backendjava.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.backendjava.model.dto.TransferValueDTO;
import com.org.backendjava.model.dto.TransferValueView;
import com.org.backendjava.model.entity.Transference;
import com.org.backendjava.model.entity.User;
import com.org.backendjava.model.entity.Wallet;
import com.org.backendjava.model.enums.TypeUser;
import com.org.backendjava.repository.TransferenceRepository;
import com.org.backendjava.repository.UserRepository;
import com.org.backendjava.repository.WalletRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class TransferenceService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private WalletRepository walletRepository;
	@Autowired
	private TransferenceRepository transferenceRepository;
	@Autowired
	private AuthorizeService authorizeService;

	@Transactional
	public TransferValueView transferValue(TransferValueDTO dto) {
		User payer = userRepository.findById(dto.payer())
				.orElseThrow(() -> new EntityNotFoundException("pagador não encontrado"));
		User payee = userRepository.findById(dto.payee())
				.orElseThrow(() -> new EntityNotFoundException("beneficiario não encontrado"));
		Wallet walletPayer = walletRepository.findByUser(payer)
				.orElseThrow(() -> new EntityNotFoundException("carteira do pagador não encontrado"));
		Wallet walletPayee = walletRepository.findByUser(payee)
				.orElseThrow(() -> new EntityNotFoundException("carteira do beneficiario não encontrado"));
		
		validateTransferValue(walletPayer.getBalance(), dto.value(), payer.getTypeUser());
		
		walletPayer.setBalance(walletPayer.getBalance().subtract(dto.value()));
		walletPayee.setBalance(walletPayee.getBalance().add(dto.value()));
		Transference transference = new Transference(null, LocalDateTime.now(), dto.value(), payer, payee);
		
		authorizeService.authorization();
		
		walletRepository.save(walletPayer);
		walletRepository.save(walletPayee);
		transference = transferenceRepository.save(transference);
		
		TransferValueView view = new TransferValueView(transference, walletPayer.getBalance(), walletPayee.getBalance());
		return view;
	}
	
	
	private void validateTransferValue(BigDecimal balancePayer, BigDecimal tranferenceValue, TypeUser typePayer) {
		if (typePayer == TypeUser.MERCHANT)
			throw new RuntimeException("mercador não pode fazer transferência");
		if (tranferenceValue.longValue() == 0)
			throw new RuntimeException("valor da transferência não pode ser 0");
		if (tranferenceValue.longValue() > balancePayer.longValue())
			throw new RuntimeException("saldo insuficiente");
	}
}
