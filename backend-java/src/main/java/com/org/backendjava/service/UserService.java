package com.org.backendjava.service;

import org.springframework.stereotype.Service;

import com.org.backendjava.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
	private final UserRepository repository;
}