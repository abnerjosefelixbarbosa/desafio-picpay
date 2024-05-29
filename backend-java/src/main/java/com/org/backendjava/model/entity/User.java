package com.org.backendjava.model.entity;

import java.io.Serializable;

import com.org.backendjava.model.enums.TypeUser;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "full_Name", nullable = false)
	private String fullName;
	@Column(name = "docment", unique = true, nullable = false)
	private String docment;
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	@Column(name = "password", unique = true, nullable = false)
	private String password;
	@Enumerated(EnumType.STRING)
	@Column(name = "type_user", nullable = false)
	private TypeUser typeUser;
}