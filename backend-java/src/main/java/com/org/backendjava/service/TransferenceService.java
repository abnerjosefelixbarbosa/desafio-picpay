package com.org.backendjava.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.backendjava.interfaces.ITransferenceService;
import com.org.backendjava.interfaces.IUserService;
import com.org.backendjava.interfaces.IWalletService;
import com.org.backendjava.model.dto.TransferValueDTO;
import com.org.backendjava.model.dto.TransferValueView;
import com.org.backendjava.model.entity.Transference;
import com.org.backendjava.model.entity.User;
import com.org.backendjava.model.entity.Wallet;
import com.org.backendjava.model.enums.TypeUser;
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
	public TransferValueView transferValue(TransferValueDTO dto) {
		Transference transference = new Transference();
		User payer = userService.findByIdOrDocment(dto.payer(), null);
		User payee = userService.findByIdOrDocment(dto.payee(), null);
		Wallet walletPayer = walletService.findByUser(payer);
		Wallet walletPayee = walletService.findByUser(payee);
		
		transference.setPayee(payee);
		transference.setPayer(payer);
		transference.setValue(dto.value());
		transference.setDateTime(LocalDateTime.now());
		walletPayer.subtractBalance(dto.value());
		walletPayee.addBalance(dto.value());
		
		validateTransferValue(transference, payer, walletPayer);
		
		transference = transferenceRepository.save(transference);
		walletPayee = walletService.saveWallet(walletPayee);
		walletPayer = walletService.saveWallet(walletPayer);
		
		return new TransferValueView(transference, walletPayee, walletPayer);
	}
	
	private void validateTransferValue(Transference transference, User payer, Wallet walletPayer) {
		if (transference.getValue().longValue() > walletPayer.getBalance().longValue() || transference.getValue().longValue() == 0)
			throw new RuntimeException("balance invalid");
		if (payer.getTypeUser() == TypeUser.SHOPKEEPER)
			throw new RuntimeException("user invalid");
	}
}
