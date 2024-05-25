package com.org.backendjava.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;

import com.org.backendjava.model.dto.CreateAccountDTO;

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
	@Column(name = "account", nullable = false, unique = true)
	private String account;
	@Column(name = "agence", nullable = false, unique = true)
	private String agence;
	@Column(name = "balance", nullable = false)
	private BigDecimal balance;
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	public Account(CreateAccountDTO dto) {
		User user = new User();
		user.setId(dto.userId());
		user.setDocment(dto.account());
		this.user = user;
		BeanUtils.copyProperties(dto, this);
	}
	
	public void subtractBalance(BigDecimal value) {
		balance.subtract(value);
	}
	
	public void addBalance(BigDecimal value) {
		balance.add(value);
	}
}
