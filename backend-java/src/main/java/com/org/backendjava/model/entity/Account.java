package com.org.backendjava.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name = "account_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "account")
	private String account;
	@Column(name = "agence")
	private String agence;
	@Column(name = "balance")
	private BigDecimal balance;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public void subtractBalance(BigDecimal value) {
		balance.subtract(value);
	}
	
	public void addBalance(BigDecimal value) {
		balance.add(value);
	}
}
