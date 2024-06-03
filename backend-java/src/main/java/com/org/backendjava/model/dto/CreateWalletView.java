package com.org.backendjava.model.dto;

import java.math.BigDecimal;

public record CreateWalletView(Long id, BigDecimal balance, Object user) {
}