package com.org.backendjava.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transference_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transference implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "date_time")
	private LocalDateTime dateTime;
	@Column(name = "transference_value")
	private BigDecimal transferenceValue;
	@ManyToOne
	@JoinColumn(name = "payer_id", nullable = false)
	private User payer;
	@ManyToOne
	@JoinColumn(name = "payee_id", nullable = false)
	private User payee;
}