package com.org.backendjava.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.org.backendjava.interfaces.ITransferenceService;
import com.org.backendjava.interfaces.IUserService;
import com.org.backendjava.interfaces.IWalletService;
import com.org.backendjava.model.dto.ListTransferencesView;
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
	private IUserService userService;
	@Autowired
	private IWalletService walletService;
	@Autowired
	private TransferenceRepository transferenceRepository;
	@Autowired
	private AuthorizeService authorizeService;

	@Transactional
	public TransferValueView transferValue(TransferValueDTO dto) {
		User payer = userService.findById(dto.payer(), "pagador não encontrado");
		User payee = userService.findById(dto.payee(), "beneficiario não encontrado");
		Wallet walletPayer = walletService.findByUser(payer, "carteira do pagador não encontrado");
		Wallet walletPayee = walletService.findByUser(payee, "carteira do beneficiario não encontrado");

		validateTransferValue(walletPayer.getBalance(), dto.value(), payer.getTypeUser());

		walletPayer.setBalance(walletPayer.getBalance().subtract(dto.value()));
		walletPayee.setBalance(walletPayee.getBalance().add(dto.value()));
		Transference transference = new Transference(null, LocalDateTime.now(), dto.value(), payer, payee);

		authorizeService.authorization();

		walletService.saveWallet(walletPayer);
		walletService.saveWallet(walletPayee);
		transference = transferenceRepository.save(transference);

		TransferValueView view = new TransferValueView(transference, walletPayer.getBalance(),
				walletPayee.getBalance());
		return view;
	}

	public Page<ListTransferencesView> listTransferencesByPayer(Long payer, Pageable pageable) {
		User user = userService.findById(payer, "pagador não encontrado");
		return transferenceRepository.findAllByPayer(user, pageable).map(ListTransferencesView::new);
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
