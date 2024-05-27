package com.org.backendjava.interfaces;

import com.org.backendjava.model.dto.TransferValueDTO;
import com.org.backendjava.model.dto.TransferValueView;

public interface ITransferenceService {
	TransferValueView transferValue(TransferValueDTO dto);
}