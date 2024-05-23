package com.org.backendjava.model.dto;

import java.math.BigDecimal;

public record TransferenceDTO(BigDecimal value, Long payer, Long payee) {

}