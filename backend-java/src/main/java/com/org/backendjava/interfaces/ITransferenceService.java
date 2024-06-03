package com.org.backendjava.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.org.backendjava.model.dto.ListTransferencesView;
import com.org.backendjava.model.dto.TransferValueDTO;
import com.org.backendjava.model.dto.TransferValueView;

public interface ITransferenceService {
	TransferValueView transferValue(TransferValueDTO dto);

	Page<ListTransferencesView> listTransferencesByPayer(Long payer, Pageable pageable);
}